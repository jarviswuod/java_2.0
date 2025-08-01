/*

    NOTES:
    - We are creating a generic list (just as a normal list)
    - Whenever we will trying to instanciate our generic list, we will need to say it's a generic list for which data type
    - <T> is placeholder and the compiler will replace it with a type that a user is calling it with. 
         - Example: OurGenericList<Integer>
    - items = (T[]) new Object[100] -> Instanciating our arraylist, item, to a size of 100
    - With only the constuctor, add, and getItem methods, we are still unable to iterate over our 'list'
    - ^^ this is because potentially private T[] items 'list' an instance of OurGenericList is private. We could make it public but that means we violate encapsulation policy.

    - Encapsulation policy -> You should not expose the internal implementation details as you can always change it in future if you want without affecting the clients code.
         - Example, In our case changing from array to ArrayList means you won't have access to some methods
    - Encapsulation policy -> Only expose the functionality not the internal implementation details

    - Iterable interface -> comes in super handy to help with iterating over the list
    - After implemeting OurGenericList with Iterable, it means we can use a for loop to iterate sequentially

    - The collection interface extends the Iterable interface because, a collection interface wants all the classes implementing the collecion interface to actually implement the methods of Iterable interface i.e hasNext() and .next()

 */

import java.util.Iterator;

public class _02_Iterators {
    public static void main(String[] args) {

        OurGenericList<Integer> list = new OurGenericList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        System.out.println();
        System.out.println();

        // same way of doing it all is by
        for (Object value : list) {
            System.out.println(value);
        }
    }
}

class OurGenericList<T> implements Iterable {
    private T[] items;
    private int size;

    public OurGenericList() {
        size = 0;
        items = (T[]) new Object[100];
    }

    public void add(T item) {
        items[size++] = item;
    }

    public T getItem(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new OurGenericListIterator(this);
    }

    private class OurGenericListIterator implements Iterator<T> {

        private OurGenericList<T> list;
        private int index = 0;

        public OurGenericListIterator(OurGenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            System.out.println("hasNext() called");
            return index < list.size;
        }

        @Override
        public T next() {
            System.out.println("next() called");
            return list.items[index++];
        }
    }
}