package _04_DesignPatterns.Creational.Prototype.good;

public class ShapeActions {

    public Shape duplicate(Shape shape) {

        System.out.println("Duplicating shape");
        return shape.duplicate();
    }
}
