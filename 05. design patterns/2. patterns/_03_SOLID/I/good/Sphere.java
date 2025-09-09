package _03_SOLID.I.good;

public class Sphere implements IShape3D {

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double volume() {
        return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }
}
