package _03_SOLID.I.bad;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);

        System.out.println(circle.area());
        System.out.println(circle.volume());

    }
}
