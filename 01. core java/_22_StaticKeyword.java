/*
    Static notes
        - Static means you are making something a class member and not an object member
        - Static varaibles are shared between different objects
        - You cannot use non static variables inside a static method
        - In non static methods you can use static variables
 */

public class _22_StaticKeyword {
    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        mobile.brand = "Apple";
        mobile.price = 1500;

        Mobile mobile2 = new Mobile();
        mobile2.brand = "Samsung";
        mobile2.price = 1700;

        Mobile.name = "Phone"; // Static variable access
        mobile.show(); // Non static method
        mobile2.show(); // Non static method

        Mobile.show1(mobile2); // Static method

    }
}

class Mobile {
    String brand;
    int price;
    static String name; // Static variable

    public void show() {
        System.out.println(brand + " : " + price + " : " + name);
    }

    public static void show1(Mobile obj) { // Using non static variables in a static method
        System.out.println(name + " : " + obj.price + " : " + obj.brand);
    }
}