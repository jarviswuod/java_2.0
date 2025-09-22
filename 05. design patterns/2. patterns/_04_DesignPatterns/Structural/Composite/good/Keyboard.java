package _04_DesignPatterns.Structural.Composite.good;

public class Keyboard implements Item {

    public double price = 40.00;

    @Override
    public double getPrice() {
        return price;
    }
}
