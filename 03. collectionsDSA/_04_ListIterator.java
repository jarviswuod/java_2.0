/*
    NOTES:

    interface ListIterator<E> extends Iterator<E> {
        boolean hasNext();
        boolean hasPrevious();
        E next(); -> Element after the cursor
        E previous(); -> Element before the cursor
    }

    - List provides two methods
         - ListIterator<E> listIterator()
         - ListIterator<E> listIterator(int index)

    - The ListIterator interface is bidirectional iterator for lists
    - It extends the iterator interface and allows the list to be traversed in either directions using the next() and prev()

    -> Whenever you are using a LinkedList feel free to use ListItartor interface coz you might require

 */

/*
    NOTES:
      - Any sort of data structure that requires an array or list we, should always gor for ArrayList
 */

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _04_ListIterator {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // [1, 2, 3, 4]
        ListIterator iterator = list.listIterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.previous());

        // next -> return items[index ++];
        // previous -> return items[-- index];
    }
}
