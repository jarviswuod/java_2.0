/*

    NOTES:
       - A static block is used to initialize static variables.
       - It runs ONCE when the class is loaded, before any object is created.
       - It can perform setup tasks without needing an object.
       - It executes before the constructor.
       - Only static methods and static variables are allowed inside static blocks or static methods.

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