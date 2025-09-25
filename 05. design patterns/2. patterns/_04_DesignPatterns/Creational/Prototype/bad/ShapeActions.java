package _04_DesignPatterns.Creational.Prototype.bad;

public class ShapeActions {

    public void duplicate(Shape shape) {
        if (shape instanceof Circle) {

            Circle copiedShape = (Circle) shape; // the copied shape
            Circle newShape = new Circle(); // the clone
            newShape.radius = copiedShape.radius;
            newShape.draw();
        } else if (shape instanceof Rectangle) {

            Rectangle copiedShape = (Rectangle) shape;
            Rectangle newShape = new Rectangle();
            newShape.width = copiedShape.width;
            newShape.height = copiedShape.height;
            newShape.draw();
        } else {
            throw new NullPointerException("Invalid shape provided");
        }
    }
}
