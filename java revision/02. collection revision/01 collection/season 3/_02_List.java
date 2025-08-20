/*

    NOTES:
    - List Types:
        - ArrayList
        - LinkedList
        - Vector

    - List Creation
        - default constructor -> ArrayList<>();
        - Parametized way -> ArrayList<>(Collection c);
        - addAll() -> list1.add(Collection c)

    - List features:
        - contains duplicate elements
        - contains multiple null values
        - stored in a dynamic array
        - insertion order is maintained
        - indexing start from 0 just like in arrays
        - 

    - List methods:
        - size()
        - add(element)
        - get(index)
        -> set(index, element)
        - remove(index or element)
        -> clear()
        -> isEmpty()
        - indexOf(element) / lastIndexOf(element)
        - contains(element)
        - addAll(Collection c)
        - removeAll(Collection c)
        - retainAll(Collection c)
        - containsAll(Collection c)

    - Difference between ArrayList and LinkedList
        - LinkedList implements both List and Queue hence can be used both as a list or a queue
        - LinkedList internally uses a doubly linked list while ArrayList uses a dynamic array to store elements
        - Good for manipulation, good for storage because it uses a dynamic array
        - Large storage capacity to store both value, prev and next refs, just the element
        - 

    - Iterating over list
        - basic for loop
        - Enhanced for loop
        - forEach loop
        - stream.forEach
        - while loop Iterator
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        - for loop Iterator
            for(Iterator<Integer> iterator =  list.iterator(); iterator.hasNext();) {
                System.out.println(iterator.next());
            }

    - Sorting arrayList
        - Collections.sort(list)
        - Collections.reverse(list)
        - Collections.sort(list, (arg0, arg1) -> arg0, arg1);

 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _02_List {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(12);
        list.add(44);
        list.add(29);
        list.add(68);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
