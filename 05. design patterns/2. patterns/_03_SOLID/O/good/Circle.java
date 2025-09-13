package _03_SOLID.O.good;

public class Circle extends Shape {

    private double radius;

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
