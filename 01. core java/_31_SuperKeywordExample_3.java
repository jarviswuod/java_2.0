// 3. Method Overriding and Super Calls

public class _31_SuperKeywordExample_3 {
    public static void main(String[] args) {
        Circle circle = new Circle(24);
        circle.calculateArea();
        circle.display();
    }
}

class Shape {
    protected double area;

    public void calculateArea() {
        System.out.println("Calculating area for generic shape");
    }

    public void display() {
        System.out.println("This is a shape with area: " + area);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        super.calculateArea(); // Call parent method
        super.area = Math.PI * radius * radius;
        System.out.println("Circle area calculated: " + area);
    }

    @Override
    public void display() {
        super.display(); // Call parent display
        System.out.println("Radius: " + radius);
    }
}
