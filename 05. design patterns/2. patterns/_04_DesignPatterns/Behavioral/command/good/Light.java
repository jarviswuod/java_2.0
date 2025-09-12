package _04_DesignPatterns.Behavioral.command.good;

// Receiver
public class Light {

    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }

    public void dim() {
        System.out.println("Light is Dim");
    }
}
