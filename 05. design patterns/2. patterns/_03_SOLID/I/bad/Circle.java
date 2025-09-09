package _03_SOLID.I.bad;

public class Circle implements IShape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double volume() {
        throw new NullPointerException("Volume not applicable for 2D shapes");
    }
}
