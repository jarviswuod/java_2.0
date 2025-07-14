/*
 * Inside enums, you can define/ create;
 * // 1. variables
 * // 2. constructors
 * // 3. methods
 * 
 * -> Enums extends the Enum class by defauld which explains the variables, methods, and constructors
 * 
 * NOTE:
 * -> We are creating our objects in the class itself hence making our constructor private
 * 
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

public class _46_EnumClasses {
    public static void main(String[] args) {

        for (Laptop laptop : Laptop.values()) {
            System.out.println(laptop + " : " + laptop.getPrice());
        }
    }
}