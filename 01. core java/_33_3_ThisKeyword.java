// 2. Constructor Chaining with this()

public class _33_3_ThisKeyword {
    public static void main(String[] args) {

    }
}

class Rectangle {
    private double width;
    private double height;

    // Default constructor
    public Rectangle() {
        this(1.0, 1.0); // Calls the two-parameter constructor
    }

    // Single parameter constructor (square)
    public Rectangle(double side) {
        this(side, side); // Calls the two-parameter constructor
    }

    // Two-parameter constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }
}