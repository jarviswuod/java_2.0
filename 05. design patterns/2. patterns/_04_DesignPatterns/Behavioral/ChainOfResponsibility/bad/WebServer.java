package _04_DesignPatterns.Behavioral.ChainOfResponsibility.bad;

public class WebServer {

    public void handle(HttpRequest request) {

        Validator validator = new Validator();
        validator.validate(request);

        Authenticator authenticator = new Authenticator();
        authenticator.authenticate(request);

        Logger logger = new Logger();
        logger.log(request);

        System.out.println("Request handled for " + request.getValidatedString());
    }
}
