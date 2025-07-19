/*
 * 
 * Static keyword is used for memory management primarily
 * Static blocks are used to intialize static variables
 * 
 * NOTE:
 * You cannot use a static non static variable or method inside a static block or method.
 * 
 */

public class _23_StaticBlocks {
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
        // brand = "featurePhone";
        System.out.println("In static block");
    }

    public Mobile() {
        brand = "";
        price = 200;
        System.out.println("In constructor");
    }
}