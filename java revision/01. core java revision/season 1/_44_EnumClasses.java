/*

    AI NOTES:
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

public class _44_EnumClasses {

    public static void main(String[] args) {

    }
}

enum Laptop {

    Lenovo(1200), HP(1800), Apple(400);

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private Laptop() {
        price = 900;
    }

    private Laptop(int price) {
        this.price = price;
    }

}
