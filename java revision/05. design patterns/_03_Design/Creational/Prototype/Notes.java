package _03_Design.Creational.Prototype;

/*

    NOTES:
    - Is a creational design pattern that allows creation of new objects by copying/ cloning existing ones
    - It focuses on constructing new instances by duplicating existing ones, minimizing the object creation overhead

    - We have 2 key players:
        - Prototype interface
        - Concrete Prototype

*/

public class Notes {
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

interface Shape {

    void draw();

    Shape duplicate();
}

class ShapeActions {

    public Shape duplicate(Shape shape) {

        System.out.println("Duplicating shape");
        return shape.duplicate();
    }
}

class Circle implements Shape {

    public int radius = 5;

    @Override
    public void draw() {

        System.out.println("Drawing circle");
    }

    @Override
    public Shape duplicate() {

        Circle newCircle = new Circle();
        newCircle.radius = radius;
        return newCircle;
    }
}

class Rectangle implements Shape {

    public int width = 10;
    public int height = 5;

    @Override
    public void draw() {

        System.out.println("Drawing Rectangle");
    }

    @Override
    public Shape duplicate() {

        Rectangle newRectangle = new Rectangle();
        newRectangle.width = width;
        newRectangle.height = height;
        return newRectangle;
    }
}
