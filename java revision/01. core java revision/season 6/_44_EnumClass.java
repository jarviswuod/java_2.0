/*

    NOTES:
    - It extends Enum class
    - Can have a constructor only private
    - Can only extend one class Enum but can implement several interfaces
    - looping over an enum .ordinal()

 */

public class _44_EnumClass {
    public static void main(String[] args) {

    }
}

enum Laptop {
    Dell(1230), HP(9090), Lenovo();

    private int price;

    private Laptop() {
        price = 1000;
    }

    private Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}