public class _29_2_ThisAndSuper {

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.show();
    }
}

interface Shape {
    default void show() {
        System.out.println("Show in Shape");
    }
}

interface Size {
    default void show() {
        System.out.println("Show in Size");
    }
}

class Circle implements Shape, Size {

    @Override
    public void show() {
        System.out.println("Drawing Circle");
        Shape.super.show(); // Call Shape's default method
        Size.super.show(); // Call Size's default method
    }
}
