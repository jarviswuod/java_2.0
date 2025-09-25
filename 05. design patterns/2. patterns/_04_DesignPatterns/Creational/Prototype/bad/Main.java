package _04_DesignPatterns.Creational.Prototype.bad;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.draw();

        // User clicks and drags to resize
        circle.radius = 12;

        // User adds a new rectangle to GUI
        Rectangle rectangle = new Rectangle();
        rectangle.draw();

        // User clicks and drags rectangle to resize
        rectangle.width = 20;
        rectangle.height = 12;

        // User right-clicking andselecting 'duplicate'
        ShapeActions shapeActions = new ShapeActions();
        shapeActions.duplicate(circle);
        shapeActions.duplicate(rectangle);
    }
}
