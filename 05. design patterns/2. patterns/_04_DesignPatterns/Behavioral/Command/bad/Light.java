package _04_DesignPatterns.Behavioral.Command.bad;

// Receiver
public class Light {

    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}
