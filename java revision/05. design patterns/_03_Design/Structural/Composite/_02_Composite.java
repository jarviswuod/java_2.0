package _03_Design.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

/*

    NOTES:
    - Is a structural design pattern that groups collections of objects into a tree-like structure where both the group of objects and individual objects are treated in a unified manner
    - Key players:
        - Component
        - Leaf
        - Composite

    - Pricing of a delivery package

*/

public class _02_Composite {
    public static void main(String[] args) {

        _02_Box box1 = new _02_Box();
        _02_Box box2 = new _02_Box();
        _02_Box box3 = new _02_Box();

        box1.addItem(new _02_Keyboard());
        box3.addItem(box1);
        box3.addItem(new _02_Mouse());
        box3.addItem(new _02_Monitor());

        box2.addItem(box3);
        box2.addItem(box1);
        box2.addItem(new _02_Monitor());

        System.out.println("Total price of items is equal to " + box2.getPrice());

    }
}

interface _02_Item {

    double getPrice();
}

class _02_Box implements _02_Item {

    private List<_02_Item> list = new ArrayList<>();

    public void addItem(_02_Item item) {
        list.add(item);
    }

    @Override
    public double getPrice() {
        double total = 0;

        for (_02_Item item : list) {
            total += item.getPrice();
        }

        return total;
    }
}

class _02_Mouse implements _02_Item {

    double price = 12.4;

    @Override
    public double getPrice() {
        return price;
    }
}

class _02_Keyboard implements _02_Item {

    double price = 5.4;

    @Override
    public double getPrice() {
        return price;
    }
}

class _02_Monitor implements _02_Item {

    double price = 10.4;

    @Override
    public double getPrice() {
        return price;
    }
}
