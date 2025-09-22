package _04_DesignPatterns.Structural.Composite.good;

public class Mouse implements Item {

    public double price = 18.00;

    @Override
    public double getPrice() {
        return price;
    }
}
