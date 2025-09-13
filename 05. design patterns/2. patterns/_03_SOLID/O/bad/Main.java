package _03_SOLID.O.bad;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Shape();

        shape.length = 12;
        shape.width = 12;

        System.out.println(shape.calculateArea(ShapeType.Rectangle));

    }
}
