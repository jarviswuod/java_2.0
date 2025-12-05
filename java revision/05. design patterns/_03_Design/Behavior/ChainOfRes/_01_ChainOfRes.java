package _03_Design.Behavior.ChainOfRes;

/*

    NOTES:
    - Is a behavioral design pattern that consists of a group of objects that can either process a request or pass it along for the next objct to process it
    - Key players:
        - Handler interface
        - Concrete Handler

    - Example:
        - Logging in

*/

public class _01_ChainOfRes {
    public static void main(String[] args) {

        Validator_ validator = new Validator_();
        Authenticate_ authenticate = new Authenticate_();
        Logging_ logging = new Logging_();

        validator.setNextHandler(authenticate).setNextHandler(logging);

        WebService_ webService = new WebService_(validator);
        webService.handle(new HttpRequest_("admin ", " pass"));
        System.out.println();

        webService.handle(new HttpRequest_("Jarvis", "pass"));
        System.out.println();

        webService.handle(new HttpRequest_("admin", ""));
    }
}

class HttpRequest_ {
    private String userName;
    private String password;

    private String validUsername;
    private String validPassword;

    public HttpRequest_(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidUsername() {
        return validUsername;
    }

    public void setValidUsername(String validUsername) {
        this.validUsername = validUsername;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }
}

abstract class Handler_ {

    private Handler_ nextHandler;

    public Handler_ setNextHandler(Handler_ nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handle(HttpRequest_ request) {
        if (!doHandle(request))
            return;
        if (nextHandler != null)
            nextHandler.handle(request);
    }

    public abstract boolean doHandle(HttpRequest_ request);
}

class WebService_ {
    private Handler_ handler;

    public WebService_(Handler_ handler) {
        this.handler = handler;
    }

    public void handle(HttpRequest_ request) {
        handler.handle(request);
    }
}

class Validator_ extends Handler_ {

    @Override
    public boolean doHandle(HttpRequest_ request) {
        System.out.println("** Validation started");

        if (request.getUserName().isEmpty() || request.getPassword().isEmpty())
            return false;
        request.setValidUsername(request.getUserName().trim());
        request.setValidPassword(request.getPassword().trim());
        System.out.println("Validation successful ...");
        return true;
    }
}

class Authenticate_ extends Handler_ {

    @Override
    public boolean doHandle(HttpRequest_ request) {
        System.out.println("** Authentication started");

        if (!(request.getValidUsername().equals("admin") && request.getValidPassword().equals("pass")))
            return false;

        System.out.println("Authentication successful ...");
        return true;
    }
}

class Logging_ extends Handler_ {

    @Override
    public boolean doHandle(HttpRequest_ request) {
        System.out.println("Logging user Data ...");
        return true;
    }
}
