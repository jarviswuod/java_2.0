/*

    OFFHEAD NOTES:
      - private because its a constructor
      - constructor it calls an Enum class

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
