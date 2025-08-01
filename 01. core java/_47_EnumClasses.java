/*

    NOTES:
       - Enums are special classes for defining constant values
       - Defined using the `enum` keyword
       - Enum constants are implicitly `public`, `static`, and `final`
       - Enum classes extend `java.lang.Enum` by default (cannot extend other classes)
       - Constructors in enums are always private (objects are defined within the class)
       - Can include fields, methods, and constructors
       - Can implement interfaces (but not extend classes)
       - Use `values()` to iterate and `name()` or `ordinal()` to get details
       - Use `==` or `.equals()` for comparison

 */

enum Laptop {
    MacBook(2000), XPS(2000), Surface, ThinkPad(800);

    private int price;

    private Laptop() {
        price = 500;
        System.out.println("Default Laptop " + this.name());
    }

    private Laptop(int price) {
        this.price = price;
        System.out.println("In Laptop " + this.name());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class _47_EnumClasses {
    public static void main(String[] args) {

        for (Laptop laptop : Laptop.values()) {
            System.out.println(laptop + " : " + laptop.getPrice());
        }
    }
}