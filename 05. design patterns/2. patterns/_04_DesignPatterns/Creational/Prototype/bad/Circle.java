package _04_DesignPatterns.Creational.Prototype.bad;

public class Circle implements Shape {

    public int radius = 5;

    @Override
    public void draw() {

        System.out.println("Drawing circle");
    }
}
