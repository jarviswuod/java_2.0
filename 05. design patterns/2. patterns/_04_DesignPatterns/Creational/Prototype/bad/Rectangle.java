package _04_DesignPatterns.Creational.Prototype.bad;

public class Rectangle implements Shape {

    public int width = 10;
    public int height = 5;

    @Override
    public void draw() {

        System.out.println("Drawing Rectangle");
    }
}
