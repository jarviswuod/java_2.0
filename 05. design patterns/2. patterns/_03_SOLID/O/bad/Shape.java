package _03_SOLID.O.bad;

public class Shape {

    public ShapeType shapeType;
    public double radius;
    public double length;
    public double width;

    public double calculateArea() {
        switch (shapeType) {
            case Rectangle:
                return length * width;

            case Circle:
                return Math.PI * Math.pow(radius, 2);

            default:
                throw new NullPointerException("Shape is invalid");
        }
    }
}
