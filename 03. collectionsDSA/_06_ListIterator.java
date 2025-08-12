/*

    NOTES:
    - The ListIterator interface is bidirectional iterator for lists
    - It extends the iterator interface and allows the list to be traversed in either directions using the next() and prev()

    - Whenever you are using a LinkedList feel free to use ListItartor interface coz you might require

        interface ListIterator<E> extends Iterator<E> {
            boolean hasNext();
            boolean hasPrevious();
            E next(); -> Element after the cursor
            E previous(); -> Element before the cursor
        }

        - ListItartor provides two methods
            - ListIterator<E> listIterator()
            - ListIterator<E> listIterator(int index)


 */

/*
    NOTES:
      - Any sort of data structure that requires an array or list we, should always gor for ArrayList
 */

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _06_ListIterator {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        // [11, 22, 33, 44]
        ListIterator iterator = list.listIterator();

        System.out.println(iterator.next()); // 11
        System.out.println(iterator.next()); // 22
        System.out.println(iterator.next()); // 33
        System.out.println(iterator.previous()); // 33

        // next() -> return items[index ++];
        // previous() -> return items[-- index];
    }
}