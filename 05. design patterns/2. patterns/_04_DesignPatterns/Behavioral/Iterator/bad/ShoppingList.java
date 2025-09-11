package _04_DesignPatterns.Behavioral.Iterator.bad;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

    private List<String> list = new ArrayList<>();
    // private int[] list = new int[5];

    public void push(String itemName) {
        list.add(itemName);
    }

    public String pop() {
        return list.remove(list.size() - 1);
    }

    public List<String> getList() {
        return list;
    }
}
