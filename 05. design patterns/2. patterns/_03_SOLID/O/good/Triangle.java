package _03_SOLID.O.good;

public class Triangle extends Shape {

    private double height;
    private double base;

    @Override
    public double calculateArea() {
        return (1 / 2 * base * height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
}
