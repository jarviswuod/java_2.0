package _03_Design.Behavior.Iterator;

import java.util.ArrayList;
import java.util.List;

/*

    NOTES:
    - Is a strcutural design pattern that defines a way of iterating over a collection of objects with affecting object internals. Change in the internals should not affect the logic
    - Key players:
        - Iterator interface
        - Concrete Iterator
        - Collection interface
        - Concrete Collection

    - Example:
        - Shoppping list

*/

public class _02_Iterator {
    public static void main(String[] args) {

        _02_ShoppingList<Integer> items = new _02_ShoppingList<>();
        items.setItems(List.of(12, 34, 9, 34));

        _02_Iterator_<Integer> iterator = items.iterate();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface _02_Iterator_<T> {

    T next();

    boolean hasNext();
}

class _02_ShoppingList<T> {

    private List<T> items = new ArrayList<>();

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void add(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    private T getItem(int position) {
        return items.get(position);
    }

    public int size() {
        return items.size();
    }

    public _02_Iterator_<T> iterate() {
        return new _Iterator<T>(this);
    }

    private class _Iterator<T> implements _02_Iterator_<T> {

        private _02_ShoppingList<T> shoppingList;
        private int index;

        public _Iterator(_02_ShoppingList<T> shoppingList) {
            this.shoppingList = shoppingList;
            index = 0;
        }

        @Override
        public T next() {
            if (index < shoppingList.size())
                return shoppingList.getItem(index++);

            return null;
        }

        @Override
        public boolean hasNext() {
            return index < shoppingList.size();
        }
    }
}
