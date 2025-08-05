/*
    Enum
    extends the Enum class
    private because everything is internal
    .value() toString()

 */

public class _44_EnumClass {

    public static void main(String[] args) {

    }
}

enum Laptop {

    Hp(1500), Dell(1000), Apple(1200), Lenovo;

    private int price;

    private Laptop() {
        price = 1600;
    }

    public int getPrice() {
        return price;
    }

    private Laptop(int price) {
        this.price = price;
    }

}