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