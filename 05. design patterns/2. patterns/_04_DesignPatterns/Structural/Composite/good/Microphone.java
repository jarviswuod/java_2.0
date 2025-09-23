package _04_DesignPatterns.Structural.Composite.good;

public class Microphone implements Item {

    public double price = 29.99;

    @Override
    public double getPrice() {
        return price;
    }
}
