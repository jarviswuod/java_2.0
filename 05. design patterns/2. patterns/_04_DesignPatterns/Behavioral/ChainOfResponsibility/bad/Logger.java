package _04_DesignPatterns.Behavioral.ChainOfResponsibility.bad;

public class Logger {

    public void log(HttpRequest request) {
        System.out.println("Logging request for " + request.getValidatedString());
    }
}
