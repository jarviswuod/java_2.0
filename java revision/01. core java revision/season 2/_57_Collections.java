/*

    Collections
     - List -> ArrayList, LinkedList
     - Queue -> ArrayDeque
     - Sets -> HashSet, TreeSet

     - Map -> HashMap, Hashtable, TreeMap

 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class _57_Collections {

    public static void main(String[] args) {
        Collection list = new ArrayList<>();
        list.add(99);
        list.add(29);
        list.add(39);

        List list1 = new ArrayList<>();
        list1.add(13);
        list1.add(129);
        list1.add(4099);

        System.out.println(list);
        System.out.println(list1);
    }
}
