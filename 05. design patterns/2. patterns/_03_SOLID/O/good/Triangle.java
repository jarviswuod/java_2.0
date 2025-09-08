package _03_SOLID.O.good;

public class Triangle extends Shape {

    private double height;
    private double base;

    @Override
    public double calculateArea() {
        return (1 / 2 * base * height);
    }
}
