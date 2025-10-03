package _03_SOLID.I.bad;

public class Sphere implements Shape {

    private double radius;

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double volume() {
        return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }
}
