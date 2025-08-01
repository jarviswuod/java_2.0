// 4. Resolving Same Interface Method Names Conflicts

public class _33_9_SuperAndThis {
    public static void main(String[] args) {
        ColoredShape coloredShape = new ColoredShape();

        coloredShape.draw();
        coloredShape.setColor("Red");

        System.out.println();

        coloredShape.draw();

    }
}

interface Drawable {
    default void draw() {
        System.out.println("Drawing using default method");
    }

    void render();
}

interface Colorable {
    default void draw() {
        System.out.println("Drawing with color");
    }

    void setColor(String color);
}

class ColoredShape implements Drawable, Colorable {
    private String color;

    @Override
    public void draw() {
        // Used to resolve conflicts when implementing multiple interfaces with same
        // method names
        Drawable.super.draw(); // Call specific interface default method
        Colorable.super.draw(); // Call other interface default method
        System.out.println("Drawing colored shape with color: " + this.color);
    }

    @Override
    public void render() {
        System.out.println("Rendering colored shape");
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}