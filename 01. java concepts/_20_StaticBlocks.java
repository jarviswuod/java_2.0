public class _20_StaticBlocks {
    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        mobile.brand = "Apple";
        mobile.price = 1500;

        Mobile mobile2 = new Mobile();
        mobile2.price = 1000;

        Mobile.name = "Smartphone";

    }
}

class Mobile {
    String brand;
    int price;
    static String name;

    static {
        name = "Phone";
        System.out.println("In static block");
    }

    public Mobile() {
        brand = "";
        price = 200;
        System.out.println("In constructor");

    }
}