package _04_DesignPatterns.Behavioral.ChainOfResponsibility.good;

public class Main {
    public static void main(String[] args) {

        Validator validator = new Validator();
        Authenticator authenticator = new Authenticator();
        Logger logger = new Logger();

        validator.setNext(authenticator).setNext(logger);

        WebServer server = new WebServer(validator);

        HttpRequest request = new HttpRequest("admin", "admin@123");
        server.handle(request);

        System.out.println("---");

        HttpRequest request2 = new HttpRequest("admin", "@123");
        server.handle(request2);

        System.out.println("---");

        HttpRequest request3 = new HttpRequest("", "");
        server.handle(request3);
    }
}
