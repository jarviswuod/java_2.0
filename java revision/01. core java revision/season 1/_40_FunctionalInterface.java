/*

    OFFHEAD NOTES:
     - A functional interface is an interface that contains exactly one abstract method.
     - It can have multiple default or static methods, but only one abstract method.
     - Functional interfaces are used primarily to define the target type for lambda expressions.

 */

public class _40_FunctionalInterface {

    public static void main(String[] args) {
        new Circle().mathArea(12);
        new Circle().mathArea(24);
    }
}

@FunctionalInterface
interface Area {
    Area mathArea(int radius);
}

class Circle implements Area {

    @Override
    public Circle mathArea(int radius) {

        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle with a radius of " + radius + " is : " + Math.round(area));
        return this;
    }
}