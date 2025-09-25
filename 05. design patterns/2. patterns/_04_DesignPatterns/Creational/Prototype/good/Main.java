package _04_DesignPatterns.Creational.Prototype.good;

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

        System.out.println();

        // User right-clicking andselecting 'duplicate'
        ShapeActions shapeActions = new ShapeActions();
        Shape newcircle = shapeActions.duplicate(circle);
        newcircle.draw();

        Shape newrectangle = shapeActions.duplicate(rectangle);
        newrectangle.draw();

    }
}
