package _04_DesignPatterns.Behavioral.ChainOfResponsibility.good;

public class Logger extends Handler {

    @Override
    public boolean doHandle(HttpRequest request) {
        System.out.println("Logging request for " + request.getValidatedString());

        return false;
    }
}
