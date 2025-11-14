package _04_DesignPatterns.Behavioral.ChainOfResponsibility;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Let's say we have a web page that contains some information that only admins of the website can access say as a page that allows an admin to manage the website's users. e.g create new users, get informatiOn, update users information etc


    - SOLUTION 1:
        - HttpsRequest class:
            - Here we introduce 4 fields
                - First 2 fields are user input fields; username and password
                - Other fields needed are validateUsername and validatePassword

            - When a user passes a username and passord, validateUsername and validatePassword fields will be populated cleaning up the user inputs
            - We also create a constructor so that username and password can be set
            - Finally generate setters and getters for the 4 fields

                    public class HttpRequest {

                        private String username;
                        private String password;

                        public String validatedString;
                        public String validatedPassword;

                        public HttpRequest(String username, String password) {
                            this.username = username;
                            this.password = password;
                        }

                        public String getUsername() {
                            return username;
                        }

                        public void setUsername(String username) {
                            this.username = username;
                        }
                    }


        - Validator class:
            - This class validates data attached to the HttpRequest i.e username and password

                public class Validator {
                    public void validate(HttpRequest request) {

                        String username = request.getUsername();
                        String password = request.getPassword();

                        // Trim whitespaces
                        request.setValidatedString(username.trim());
                        request.setValidatedPassword(password.trim());

                    }
                }


        - Authenticator class;
            - Once the request has been validated it needs to be pass to the Authenticator class
            - We confirm if password and username passed is matching database data

                public class Authenticator {
                    public boolean authenticate(HttpRequest request) {
                        String username = request.getValidatedString();
                        String password = request.getValidatedPassword();

                        return "admin".equals(username) && "admin@123".equals(password);
                    }
                }


        - Logger class:
            - Once authentication and validation operations are done. We log the info to console

                public class Logger {

                    public void log(HttpRequest request) {
                        System.out.println("Logging request for " + request.getValidatedString());
                    }
                }


        - WebServer class:
            - Here we have a handle() method which will handle our requests taking HttpRequest like all the other methods
            - We then piece everything in order starting by request validation

                    public class WebServer {
                        public void handle(HttpRequest request) {

                            Validator validator = new Validator();
                            validator.validate(request);

                            ...
                        }
                    }


            - Then create an authenticator
                - NOTE that in real servers we throw errors if something ain't adding up under authentication say "access denied"

                    public class WebServer {
                        public void handle(HttpRequest request) {

                            Authenticator authenticator = new Authenticator();
                            authenticator.authenticate(request);

                            ...
                        }
                    }


            - Finally we create a logger

                    public class WebServer {
                        public void handle(HttpRequest request) {

                            Logger logger = new Logger();
                            logger.log(request);

                            ...
                        }
                    }



        - Main class: Client class
            - We are simulating how a client will use our solution
            - First we create a WebServer object
            - Then create a HttpRequest object with username and password, just as a user does in a form from an end user session

            - Finally we call handle() method from the server object

                public class Main {
                    public static void main(String[] args) {

                        WebServer server = new WebServer();
                        HttpRequest request = new HttpRequest("admin", "admin@123");

                        server.handle(request);
                    }
                }


        - Problems with this approach:
            - Under handle() method inside the WebServer class, the order of operation are hardcoded inside the WebServer so in the future if you wanted to disable login or authentication for a certain scenario roots and webpages we cannot do so. We have to come back and modify the code in the WebServer class itself. This violates the OCP
            - Chain of responsiblity solves this as you can build a pipeline with a chain of objects for processing a request as the request can be of any type not just HTTP Request

            - Another issue is since we have the new keyword within the WebServer class, there's tight coupling between the concrete authenicator, valiadator, logger and whatever class. To solve this we have to extract interfaces from the classes and have a WebServer talk to the interfaces rather than the concrete classes. This makes our WebServer class more flexible for you could just swap to a different type or validator, authenticator or logger



    - SOLUTION USING CHAIN OF COMMAND:
        - abstract Hander class:
            - We need to store the next Hander object/class in chain
            - We need a setNext() method to help in setting out nextHandler
                - We return Handler in setNext() method because it enables to chaining/ linking handlers in a conventiend way. Example; h1.setNext(h2).setNext(h3).setNext(h4);

                public abstract class Handler {

                    private Handler nextHandler;

                    public Handler setNext(Handler nextHandler) {
                        this.nextHandler = nextHandler;
                        return nextHandler;
                    }

                    ...
                }


            - Next is creating handle() template method. It receives a HttpRequest and inside of it we have an if-else() condition. Meaning, if dohandle() method returns true, we return early ending the process else we check if the nextHandler field is not equal to null then we call the nextHander.handle() method passing along the request object
                - doHandle() is an abstract method that returns a boolean and takes in a HttpRequest object
                - It will be implemented in the concrete Handler classes

                        public abstract class Handler {

                            public void handle(HttpRequest request) {
                                if (doHandle(request)) {
                                    return;
                                }

                                if (nextHandler != null) {
                                    nextHandler.handle(request);
                                }
                            }

                            public abstract boolean doHandle(HttpRequest request);

                            ...
                        }



        - Concrete Handler classes:
            - Validator class;
                - We essentially do what we did before i.e getting the username & password from the request object then trimming the whitespaces setting in appropriate fields
                - We do all this inside the overrided method dohandel() and we return false to mean we are not done with processing the request and the next Handler should be called
                - For this concrete methods, we should always return false as reason to stop processing the request

                    public class Validator extends Handler {

                        @Override
                        public boolean doHandle(HttpRequest request) {

                            String username = request.getUsername();
                            String password = request.getPassword();

                            request.setValidatedString(username);
                            request.setValidatedPassword(password);

                            System.out.println("Validation successful for " + username);

                            return request.getValidatedString() == "" || request.getValidatedPassword() == "";
                        }
                    }


            - Authenticator class:
                - The return should be false if everything matches up as expected i.e the database's username and password. For this to happen we have to negate(!) the value to false to ensure the process continues i.e calling the next Handler class

                    public class Authenticator extends Handler {

                        @Override
                        public boolean doHandle(HttpRequest request) {
                            String username = request.getValidatedString();
                            String password = request.getValidatedPassword();

                            return !("admin".equals(username) && "admin@123".equals(password));
                        }
                    }


            - Logger class:
                - What we do here is to log to the console then return false, nothing fancy and this means essentially the request never fails
                    public class Logger extends Handler {

                        @Override
                        public boolean doHandle(HttpRequest request) {
                            System.out.println("Logging request for " + request.getValidatedString());

                            return false;
                        }
                    }


        - WebServer class:
            - In here we need to store a reference to the first Handler in the chain and then pass it in the constructor
            - We also provide handle() method which takes in HttpRequest and calls handle() method to delegate task to the concrete class

                    public class WebServer {

                        private Handler handler;

                        public WebServer(Handler handler) {
                            this.handler = handler;
                        }

                        public void handle(HttpRequest request) {
                            handler.handle(request);
                        }
                    }



        - Main Class: Client class
            - First we create a Validator, Authenticator and Logger objects

                    public class Main {
                        public static void main(String[] args) {

                            Validator validator = new Validator();
                            Authenticator authenticator = new Authenticator();
                            Logger logger = new Logger();

                            ...
                        }
                    }


            - Then return handlers from the setNext() method and because of that we chain everything in one line
            - We basically call validator because it's the first object in our chain
            - We then create our server passing the first object in chain which is validator
                    public class Main {
                        public static void main(String[] args) {

                            validator.setNext(authenticator).setNext(logger);
                            WebServer server = new WebServer(validator);

                            ...
                        }
                    }


            - We then create a HttpRequest object passing in a username and passowrd
            - Then we handle the request
                    public class Main {
                        public static void main(String[] args) {

                            HttpRequest request = new HttpRequest("admin", "admin@123");
                            server.handle(request);

                            ...
                        }
                    }


            - It all works perfectly, logging every detail as needed
            - When we test with the wrong username or password, it also works as expected, i.e not all objects are executed as the chain stops midway

                    public class Main {
                        public static void main(String[] args) {

                            HttpRequest request2 = new HttpRequest("admin", "@123");
                            server.handle(request2);

                            HttpRequest request3 = new HttpRequest("", ""); 
                            server.handle(request3); 

                            ...
                        }
                    }

 */

public class Explanation {

}
