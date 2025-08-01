/*

    NOTES:
       - `static` makes a member belong to the class, not to instances (objects).
       - It's mainly used for memory efficiency and shared access.
       - Static variables are shared across all instances of the class.
       - Static methods cannot access non-static variables directly.
       - Non-static methods can access both static and non-static members.
       - Examples: 
           - Static method -> public static void methodName() { ... }
           - Static variable -> static String name = "";
           - Static block -> static { ... }

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