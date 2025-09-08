package _03_SOLID.L.good;

public class Main {
    public static void main(String[] args) {

        Shape rect = new Rectangle(5, 4);
        System.out.println("Calculated area : " + rect.area());

        Shape square = new Square(5);
        System.out.println("Calculated area : " + square.area());
    }
}
