package _03_SOLID.L.bad;

public class Rectangle extends Shape {
    protected double length;
    protected double width;

    @Override
    public double area() {
        return length * width;
    }
}
