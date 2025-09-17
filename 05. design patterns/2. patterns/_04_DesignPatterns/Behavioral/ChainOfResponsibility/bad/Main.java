package _04_DesignPatterns.Behavioral.ChainOfResponsibility.bad;

public class Main {
    public static void main(String[] args) {

        WebServer server = new WebServer();
        HttpRequest request = new HttpRequest("admin", "admin@123");

        server.handle(request);
    }
}
