package _04_DesignPatterns.Behavioral.Iterator.good;

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

    public Iterator<String> createIterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<String> {

        private ShoppingList shoppingList;

        private int index;

        public ListIterator(ShoppingList shoppingList) {
            this.shoppingList = shoppingList;
        }

        @Override
        public void next() {
            index++;
        }

        @Override
        public boolean hasNext() {
            return index < shoppingList.list.size();
        }

        @Override
        public String current() {
            return shoppingList.list.get(index);
        }
    }
}
