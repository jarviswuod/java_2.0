package _03_Design.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

/*

    NOTES:
    - Is a strcutural design pattern that uses a tree-like structure to reprensent a group of objects with both individual objects and group of objects treated as a unified manner
    - Key players:
        - Component
        - Leaf
        - Composite

    - Example:
        - Delivery package pricing model

*/

public class _01_Composite {
    public static void main(String[] args) {

        Box_ box1 = new Box_();
        box1.add(new Monitor_());

        Box_ box2 = new Box_();
        box2.add(new Mouse_());

        Box_ box3 = new Box_();
        box3.add(new Keyboard_());

        Box_ box4 = new Box_();
        box4.add(box2);
        box4.add(box3);

        Box_ box5 = new Box_();
        box5.add(box1);
        box5.add(box4);
        box5.add(new Mouse_());

        System.out.println("Total price is equal to " + box5.getPrice());
    }
}

interface Item_ {

    double getPrice();
}

class Box_ implements Item_ {

    private List<Item_> items = new ArrayList<>();

    public void add(Item_ item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Item_ item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

class Mouse_ implements Item_ {

    private double price = 1;

    @Override
    public double getPrice() {
        return price;
    }
}

class Keyboard_ implements Item_ {

    private double price = 2;

    @Override
    public double getPrice() {
        return price;
    }
}

class Monitor_ implements Item_ {

    private double price = 3;

    @Override
    public double getPrice() {
        return price;
    }
}