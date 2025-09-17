package _04_DesignPatterns.Behavioral.ChainOfResponsibility.good;

public abstract class Handler {

    private Handler nextHandler;

    public Handler setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handle(HttpRequest request) {
        if (doHandle(request)) {
            return;
        }

        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }

    public abstract boolean doHandle(HttpRequest request);
}
