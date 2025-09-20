package _04_DesignPatterns.Behavioral.ChainOfResponsibility;

/*

    NOTES:
    - SOLUTION ONE:
        - HttpsResuest class:
            - Here we ened 4 fields
                - first 2 fields are user input fields;
                    - username and password

                - Other fields needed are validateUsername and validatePassword

            - WHen a user passes a username and passord, the 2 other fields vlaivatedUsername and validatePassword will be populated clearning up the user inputs

            - We also create a constructor so that udername and passowrd can be set
            - Finally generate settera dna getters for the 4 fields

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
                - This class validates our data attached to the HttpResuest i.e username and password

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
                - Once teh resuest has been validated we need to pass it to ehte authenticator class
                - we keep it simple by only confirming the password and username passed is matching what we ha ve in the database
                    public class Authenticator {

                        public boolean authenticate(HttpRequest request) {
                            String username = request.getValidatedString();
                            String password = request.getValidatedPassword();

                            return "admin".equals(username) && "admin@123".equals(password);
                        }
                    }

            - Logger class:
                - Once we have been through the authentication and validation we can perform login. We have a simple method for loggin to the console
                    public class Logger {

                        public void log(HttpRequest request) {
                            System.out.println("Logging request for " + request.getValidatedString());
                        }
                    }

            - WebServer class:
                - FInally we create a webServer class. we have a method called handle which will handle our request, it takes in a HttpRewuest like all the other methods.
                - Here we put in together everything we have created in order, we start by validating the request, this will populate teh requests objects with validate username and password
                        public class WebServer {
                            public void handle(HttpRequest request) {

                                Validator validator = new Validator();
                                validator.validate(request);

                                ...
                            }
                        }


                - then created the authenticator
                    - NOTE; In real server we would throw an error if something was adding up under authentication say return a page with access denied

                        public class WebServer {
                            public void handle(HttpRequest request) {


                                Authenticator authenticator = new Authenticator();
                                authenticator.authenticate(request);

                                ...
                            }
                        }

                - FInally we create a logger

                        public class WebServer {
                            public void handle(HttpRequest request) {

                                Logger logger = new Logger();
                                logger.log(request);

                                ...
                            }
                        }



            - Main class: client class
                - we are simulating how a client will use our soltuion
                - first we createa webserver object
                - then createa HttpRequest object with username and password, just as user will pass it in or from froma end user session

                - FInally we call handle() method from the server object

                    public class Main {
                        public static void main(String[] args) {

                            WebServer server = new WebServer();
                            HttpRequest request = new HttpRequest("admin", "admin@123");

                            server.handle(request);
                        }
                    }

        - Probles with this approach:
            -  under handle() method inside the Websierver class, the order of operation are hardcoded inside the webserver so in the future if you wanted to disable login orauthentication for a certain scenario roots and weebpages we cannot do so, we have to come back and modify the code in the webserver class itself. THis violates the open-closed principle as changing the steps or order of steps, or adding extra steps, we'd have to modify the existing code
            - CHain of responsiblity solveds this as you can build a pipeline with a chain of objects for  processing a request and the reqeust can be of any type not just HTTP Request

            - Another issues, because of the new keyword within the Websrver class, there is tight couplign between the concrete  authenicator,valiadator, logger and whatver class. to solve this we will have could extract interfaces from the classes and have a webserver talk to the interfaces rather than the conrete classes. THis makes our webserver class more flexible because you could just swap to a different type or validator, authenticator or logger

    - SOLUTION USING CHAIN OF COMMAND:
        - abstract Hander class:
            - we need to store the next Hander object/class in chain
            - We need a setNext() method to help in settng out next Handler. Why do we return Handler? THis is because returning a Handler in this setNext() method enables/enables us to chain/link handler in a conventiend way. Example;
                - h1.setNext(h2).setNext(h3).setNext(h4)

                public abstract class Handler {

                    private Handler nextHandler;

                    public Handler setNext(Handler nextHandler) {
                        this.nextHandler = nextHandler;
                        return nextHandler;
                    }

                    ...
                }

            - Next is to create our handle() template method. It receinves a HttpRequest and Inside of it we have an if() condition
                if (doHandle(request)) {
                    return;
                }
                What thsi means is that if dohandle() method returns true, we return early and process ending else we check if the nexthandler field is not eaual to null we call the nextHander.handle methos passing along the request object


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

            - doHandle() is an abstract method that returns a boolean and takes in a HttpRequest object
            - It will be implemented in the concrete Handler classees


        - Concrete Handler classes
            - Validator class;
                - we essentially do what we did before i.e get the username and password from teh rewuest object and trim  the whitespacce setting in aprropriate fields
                - We do all this inside the oveerided methos dohandel() and we return false to mean we are not done with processing the request and the next Handler  should be called.
                - Returning true means proccessing stops here, 
                - FOr this concrete methods, we should always return false as reason to stop porcessing the request

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
                - the return should be false if everything amtches up as expected i.e the database's username and password, for this to happen we have to negate the value to false to ensure the prcess continues i.e call the next Handler class

                    public class Authenticator extends Handler {

                        @Override
                        public boolean doHandle(HttpRequest request) {
                            String username = request.getValidatedString();
                            String password = request.getValidatedPassword();

                            return !("admin".equals(username) && "admin@123".equals(password));
                        }
                    }


            - Logger class:
                - what we do here is to log to the console then return false, nothing fancy and this means essentially the request never fails
                    public class Logger extends Handler {

                        @Override
                        public boolean doHandle(HttpRequest request) {
                            System.out.println("Logging request for " + request.getValidatedString());

                            return false;
                        }
                    }


        - WebServer class:
            - IN here we need to store a reference to the first Handler in the chain and then pass it in the constructor
            - We also provide a handle() method which takes in a HttpRequest and calls handle() method to delegate task to the concrete class

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
            - First we create a Validator object then create an Authenticator object then Logger object too

                    public class Main {
                        public static void main(String[] args) {

                            Validator validator = new Validator();
                            Authenticator authenticator = new Authenticator();
                            Logger logger = new Logger();

                            ...
                        }
                    }

            - THen what we need to do is to return handlers from teh setNext() method and becasue of that we chain everything in one line
            - We basically call validator becasue its the first object in our chain
            - We then create our server passing the first objectin chain which is validator

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

            - It all workd perfectly, loggint every detail as needed
            - When we  test with the wrong username or password, it also works as expected, i.e not all objects are executed, the chain stops midway

                    public class Main {
                        public static void main(String[] args) {

                            HttpRequest request2 = new HttpRequest("admin", "@123");
                            server.handle(request2);

                            HttpRequest request3 = new HttpRequest("", ""); 
                            server.handle(request3); 

                            ...
                        }
                    }


            - 



 */

public class Explanation {

}
