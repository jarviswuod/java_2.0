package _03_SOLID.L.bad;

public class Rectangle extends Shape {
    protected double length;
    protected double width;

    @Override
    public double area() {
        return length * width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
