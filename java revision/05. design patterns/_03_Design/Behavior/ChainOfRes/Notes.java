package _03_Design.Behavior.ChainOfRes;

/*

    NOTES:
    - Is a behavioral pattern that enables the chaining of several objects where each object can be choose to processe a request or pass it to the next object on chain
    - 2 Key players:
        - Handler interface
        - Concrete Handler


    - CHAIN OF RES::: ::: ::: :::

            public class Notes {
                public static void main(String[] args) {

                    Validator validator = new Validator();
                    Authenticator authenticator = new Authenticator();
                    Logger logger = new Logger();

                    validator.setNext(authenticator).setNext(logger);
                    WebServer server = new WebServer(validator);

                    HttpRequest request = new HttpRequest("admin", "admin@123");
                    server.handle(request);

                    HttpRequest request2 = new HttpRequest("admin", "@123");
                    server.handle(request2);

                    HttpRequest request3 = new HttpRequest("", "");
                    server.handle(request3);
                }
            }

            class HttpRequest {

                private String username;
                private String password;

                public String validatedString;
                public String validPass;

                public HttpRequest(String username, String password) {
                    this.username = username;
                    this.password = password;
                }

                public String getUsername() {
                    return username;
                }

                public String getPassword() {
                    return password;
                }

                public String getValidatedString() {
                    return validatedString;
                }

                public void setValidatedString(String validatedString) {
                    this.validatedString = validatedString;
                }

                public String getValidPass() {
                    return validPass;
                }

                public void setValidPass(String validPass) {
                    this.validPass = validPass;
                }
            }

            class WebServer {

                private Handler handler;

                public WebServer(Handler handler) {
                    this.handler = handler;
                }

                public void handle(HttpRequest request) {
                    handler.handle(request);
                }
            }

            abstract class Handler {

                private Handler nextHandler;

                public Handler setNext(Handler nextHandler) {
                    this.nextHandler = nextHandler;
                    return nextHandler;
                }

                public void handle(HttpRequest request) {
                    if (doHandle(request))
                        return;

                    if (nextHandler != null)
                        nextHandler.handle(request);
                }

                public abstract boolean doHandle(HttpRequest request);
            }

            class Validator extends Handler {

                @Override
                public boolean doHandle(HttpRequest request) {

                    String username = request.getUsername();
                    String password = request.getPassword();

                    request.setValidatedString(username);
                    request.setValidPass(password);

                    System.out.println("Validation successful for " + username);

                    return request.getValidatedString().isEmpty() || request.getValidPass().isEmpty();
                }
            }

            class Authenticator extends Handler {

                @Override
                public boolean doHandle(HttpRequest request) {
                    String username = request.getValidatedString();
                    String password = request.getValidPass();

                    return !("admin".equals(username) && "admin@123".equals(password));
                }
            }

            class Logger extends Handler {

                @Override
                public boolean doHandle(HttpRequest request) {
                    System.out.println("Logging request for " + request.getValidatedString());

                    return false;
                }
            }

 */

public class Notes {
    public static void main(String[] args) {

        Validator validator = new Validator();
        Authenticator authenticator = new Authenticator();
        Logger logger = new Logger();

        validator.setNext(authenticator).setNext(logger);
        WebServer server = new WebServer(validator);

        HttpRequest request = new HttpRequest("admin", "admin@123");
        server.handle(request);
        System.out.println();

        HttpRequest request2 = new HttpRequest("admin", "@123");
        server.handle(request2);
        System.out.println();

        HttpRequest request3 = new HttpRequest("", "");
        server.handle(request3);
    }
}

class HttpRequest {

    private String username;
    private String password;

    public String validUsername;
    public String validPass;

    public HttpRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getValidUsername() {
        return validUsername;
    }

    public void setValidUsername(String validatedString) {
        this.validUsername = validatedString;
    }

    public String getValidPass() {
        return validPass;
    }

    public void setValidPass(String validPass) {
        this.validPass = validPass;
    }
}

class WebServer {

    private Handler handler;

    public WebServer(Handler handler) {
        this.handler = handler;
    }

    public void handle(HttpRequest request) {
        handler.handle(request);
    }
}

abstract class Handler {

    private Handler nextHandler;

    public Handler setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handle(HttpRequest request) {
        if (!doHandle(request))
            return;

        if (nextHandler != null)
            nextHandler.handle(request);
    }

    public abstract boolean doHandle(HttpRequest request);
}

class Validator extends Handler {

    @Override
    public boolean doHandle(HttpRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        request.setValidUsername(username);
        request.setValidPass(password);
        if (request.getValidUsername().isEmpty() || request.getValidPass().isEmpty())
            return false;

        System.out.println("Validation successful for " + username);

        return true;
    }
}

class Authenticator extends Handler {

    @Override
    public boolean doHandle(HttpRequest request) {
        String username = request.getValidUsername();
        String password = request.getValidPass();

        return "admin".equals(username) && "admin@123".equals(password);
    }
}

class Logger extends Handler {

    @Override
    public boolean doHandle(HttpRequest request) {
        System.out.println("Logging request for " + request.getValidUsername());

        return true;
    }
}
