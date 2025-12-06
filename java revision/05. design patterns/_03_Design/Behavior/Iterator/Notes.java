package _03_Design.Behavior.Iterator;

import java.util.ArrayList;
import java.util.List;

/*

    NOTES:
    - Is a behavioral pattern that provides a mechanism to iterate over an object list without exposing the internal structure, plus chaining the objects internal will not affect the iteration
    - Key players:
        - Iterator interface
        - Concrete Iterator
        - Collection interface
        - Concrete collection

    - Example:
        - Shooping list

                public class Notes {
                    public static void main(String[] args) {

                        ShoppingList<String> list = new ShoppingList<>();
                        list.add("Milk");
                        list.add("Bread");
                        list.add("Sugar");
                        list.add("Cabbage");
                        list.add("Onion");
                        list.add("Tomatoes");

                        Iterator<String> iter = list.iterate();

                        while (iter.hasNext()) {
                            System.out.println("Current : " + iter.current());
                            iter.next();
                        }
                    }
                }

                interface Iterator<T> {

                    void next();

                    boolean hasNext();

                    T current();
                }

                class ShoppingList<T> {

                    private List<T> items = new ArrayList<>();

                    public void add(T item) {
                        items.add(item);
                    }

                    public T pop() {
                        return items.remove(items.size() - 1);
                    }

                    public ListIterator<T> iterate() {
                        return new ListIterator<T>(this);
                    }

                    private class ListIterator<T> implements Iterator<T> {

                        private ShoppingList<T> shoppingList;
                        private int index;

                        public ListIterator(ShoppingList<T> shoppingList) {
                            this.shoppingList = shoppingList;
                            index = 0;
                        }

                        @Override
                        public void next() {
                            if (index < shoppingList.items.size())
                                index++;
                        }

                        @Override
                        public boolean hasNext() {
                            return index < shoppingList.items.size();
                        }

                        @Override
                        public T current() {
                            return shoppingList.items.get(index);
                        }
                    }
                }

 */

public class Notes {
    public static void main(String[] args) {

        ShoppingList<String> list = new ShoppingList<>();
        list.add("Milk");
        list.add("Bread");
        list.add("Sugar");
        list.add("Cabbage");
        list.add("Onion");
        list.add("Tomatoes");

        Iterator<String> iter = list.iterate();

        while (iter.hasNext()) {
            System.out.println("Current : " + iter.current());
            iter.next();
        }
    }
}

interface Iterator<T> {

    void next();

    boolean hasNext();

    T current();
}

class ShoppingList<T> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T pop() {
        return items.remove(items.size() - 1);
    }

    public ListIterator<T> iterate() {
        return new ListIterator<T>(this);
    }

    private class ListIterator<T> implements Iterator<T> {

        private ShoppingList<T> shoppingList;
        private int index;

        public ListIterator(ShoppingList<T> shoppingList) {
            this.shoppingList = shoppingList;
            index = 0;
        }

        @Override
        public void next() {
            if (index < shoppingList.items.size())
                index++;
        }

        @Override
        public boolean hasNext() {
            return index < shoppingList.items.size();
        }

        @Override
        public T current() {
            return shoppingList.items.get(index);
        }
    }
}
