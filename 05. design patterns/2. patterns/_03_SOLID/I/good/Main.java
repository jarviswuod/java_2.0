package _03_SOLID.I.good;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(10);
        System.out.println(circle.area());

        Sphere sphere = new Sphere(14);
        System.out.println(sphere.area());
        System.out.println(sphere.volume());
    }
}
