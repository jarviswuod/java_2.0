package _04_DesignPatterns.Structural.Composite.bad;

import java.util.ArrayList;
import java.util.List;

public class Box {

    private List<Object> items = new ArrayList<>();

    public void add(Object item) {
        items.add(item);
    }

    public double calculateTotalPrice() {

        double totalPrice = 0;

        for (Object item : items) {
            if (item instanceof Keyboard) {
                totalPrice += ((Keyboard) item).price;
            } else if (item instanceof Mouse) {
                totalPrice += ((Mouse) item).price;
            } else if (item instanceof Microphone) {
                totalPrice += ((Microphone) item).price;
            } else if (item instanceof Box) {
                totalPrice += ((Box) item).calculateTotalPrice(); // calls calculateTotalPrice() recursively
            }
        }

        return totalPrice;
    }
}
