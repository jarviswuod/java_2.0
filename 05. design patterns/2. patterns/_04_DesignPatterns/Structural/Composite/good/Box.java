package _04_DesignPatterns.Structural.Composite.good;

import java.util.ArrayList;
import java.util.List;

public class Box implements Item {

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
