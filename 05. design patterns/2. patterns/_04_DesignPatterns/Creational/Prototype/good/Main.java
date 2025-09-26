package _04_DesignPatterns.Creational.Prototype.good;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.draw();

        circle.radius = 12;

        Rectangle rectangle = new Rectangle();
        rectangle.draw();

        rectangle.width = 20;
        rectangle.height = 12;

        System.out.println();

        ShapeActions shapeActions = new ShapeActions();
        Shape newcircle = shapeActions.duplicate(circle);
        newcircle.draw();

        Shape newrectangle = shapeActions.duplicate(rectangle);
        newrectangle.draw();
    }
}
