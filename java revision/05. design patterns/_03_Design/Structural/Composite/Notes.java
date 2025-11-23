package _03_Design.Structural.Composite;

/*

    Notes:
    - Is a structural pattern that uses a tree-like structure to represent a collection of objects where individual objects and groups of objects are treated in a unified manner

    - 3 key players:
        - Component
        - Leaf
        - Composite

    - Example:
        - Amazon delivery shopping package:

                public class Notes {
                    public static void main(String[] args) {

                        Box packageBox = new Box();

                        Box box1 = new Box();
                        box1.add(new Microphone());

                        Box box2 = new Box();

                        Box box3 = new Box();
                        box3.add(new Mouse());

                        Box box4 = new Box();
                        box4.add(new Keyboard());

                        box2.add(box3);
                        box2.add(box4);

                        packageBox.add(box1);
                        packageBox.add(box2);

                        System.out.println("Total price of package : " + packageBox.getPrice());
                    }
                }

                interface Item {

                    double getPrice();
                }

                class Box implements Item {

                    private List<Item> items = new ArrayList<>();

                    public void add(Item item) {
                        items.add(item);
                    }

                    public double getPrice() {

                        double totalPrice = 0;
                        for (Item item : items) {
                            totalPrice += item.getPrice();
                        }
                        return totalPrice;
                    }
                }

                class Keyboard implements Item {

                    public double price = 20.00;

                    @Override
                    public double getPrice() {
                        return price;
                    }
                }

                class Microphone implements Item {

                    public double price = 29.99;

                    @Override
                    public double getPrice() {
                        return price;
                    }
                }

                class Mouse implements Item {

                    public double price = 18.00;

                    @Override
                    public double getPrice() {
                        return price;
                    }
                }

*/

public class Notes {
    public static void main(String[] args) {

    }
}
