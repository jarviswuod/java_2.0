package _04_DesignPatterns.Behavioral.State.overkill;

public class Stopwatch {

    private boolean isRunning = false;

    public void click() {
        if (isRunning) {
            isRunning = false;
            System.out.println("Stopped");
        } else {
            isRunning = true;
            System.out.println("Running");
        }
    }
}