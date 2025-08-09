/*

    Collection
        Map
            HashMap
            TreeMap
            Hashtable
        Set
            TreeSet
            HashSet
        Queue
            ArrayDeque
            LinkedList
        List
            ArrayList
            LinkedList

    add()
    size()
    toArray()
    List.of(, , , ,)
    indexOf()/ lastIndexOf()
    set(index, elementName);
    get(index)
    remove(elementName or index)
    addAll()
    removeAll(Collection c)
    contains(elementName or index)
    containsAll(Collection c)
    clear()

    create
        default constructor
            new ArrayList<>()

        paramettized constructor
            new ArrayList<>(Collection c)


        LinkedList
            addFirst()
            addLast()
            removeFirst()
            removeLast()

    Collections.sort(Collection c)
    Collections.reverse(Collection c)

 */

import java.util.ArrayList;
import java.util.Collection;

public class _57_Collections {

    public static void main(String[] args) {

        Collection<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(22);
        list.add(42);
        list.add(62);

        System.out.println(list);

    }
}
