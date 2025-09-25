package _04_DesignPatterns.Creational.Prototype.good;

public class Circle implements Shape {

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
