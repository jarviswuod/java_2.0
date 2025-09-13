package _03_SOLID.L.bad;

public class Main {
    public static void main(String[] args) {

        Rectangle rect = new Rectangle();
        rect.setLength(10);
        rect.setWidth(5);

        System.out.println("Expected area : 10 * 5 = 50");
        System.out.println("Calculated area : " + rect.area());

        Square square = new Square();
        square.setLength(10);
        square.setWidth(5);

        System.out.println("Expected area : 10 * 5 = 50");
        System.out.println("Calculated area : " + square.area());
    }
}
