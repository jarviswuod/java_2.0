package _03_Design.Behavior.Iterator;

import java.util.ArrayList;
import java.util.List;

/*

    NOTES:
    - Is a behavioural design pattern that enables one to iterate through a collection of objects without exposing the internals plus changing the object internals won't affect the logic
    - Key players:
        - Collection interface
        - Concrete Collection
        - Iterator interface
        - Concrete Iterator

    - Example:
        - Shopping List

*/

public class _01_Iterator {
    public static void main(String[] args) {

        _ShoppingList<Integer> list = new _ShoppingList<>();
        list.addItem(12);
        list.addItem(24);
        list.addItem(36);
        list.addItem(48);

        _Iterator<Integer> iterator = list.iterate();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println();
        System.out.println();

        _ShoppingList<String> list_ = new _ShoppingList<>();
        list_.addItem("Bread");
        list_.addItem("Milk");
        list_.addItem("Onions");
        list_.addItem("Cabbage");

        _Iterator<String> iterator_ = list_.iterate();
        while (iterator_.hasNext())
            System.out.println(iterator_.next());

    }
}

interface _Iterator<T> {

    T next();

    boolean hasNext();
}

class _ShoppingList<T> {

    private List<T> list = new ArrayList<>();

    public void addItem(T item) {
        list.add(item);
    }

    public T element(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public __Iterator<T> iterate() {
        return new __Iterator<T>(this);
    }

    private class __Iterator<T> implements _Iterator<T> {
        private int index;
        private _ShoppingList<T> shoppingList;

        public __Iterator(_ShoppingList<T> shoppingList) {
            this.shoppingList = shoppingList;
            index = 0;
        }

        @Override
        public T next() {
            if (shoppingList.size() > index) {
                return shoppingList.element(index++);
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            if (index < shoppingList.size())
                return true;
            return false;
        }
    }
}