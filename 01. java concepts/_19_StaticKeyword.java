public class _19_StaticKeyword {
    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        mobile.brand = "Apple";
        mobile.price = 1500;

        Mobile mobile2 = new Mobile();
        mobile2.brand = "Samsung";
        mobile2.price = 1700;

        Mobile.name = "Phone";
        mobile.show();
        mobile2.show();

        Mobile.show1(mobile2);

    }
}

class Mobile {
    String brand;
    int price;
    static String name;

    public void show() {
        System.out.println(brand + " : " + price + " : " + name);
    }

    public static void show1(Mobile obj) {
        System.out.println(name + " : " + obj.price + " : " + obj.brand);
    }

}