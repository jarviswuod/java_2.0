package _04_DesignPatterns.Creational.Prototype.good;

public class Rectangle implements Shape {

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
