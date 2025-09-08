package _03_SOLID.O.good;

public class Rectangle extends Shape {
    private double length;
    private double width;

    @Override
    public double calculateArea() {
        return length * width;
    }

}
