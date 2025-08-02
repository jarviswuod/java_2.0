/*

    NOTES:
    - LinkedHashSet: It is a combination of HashSet and LinkedList
    - It maintains the insertion order of elements
    - It is slower than HashSet but faster than TreeSet
    - It uses a doubly linked list to maintain the order of elements
    - It is useful when you want to maintain the order of elements while still having the benefits of a HashSet

 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class _17_LinkedHashSet {

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();

        // Adding elements to the HashSet
        hashSet.add(11);
        hashSet.add(21);
        hashSet.add(31);
        hashSet.add(71);
        hashSet.add(91);

        // Displaying the HashSet
        System.out.println("HashSet: " + hashSet);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        // Adding elements to the HashSet
        linkedHashSet.add(11);
        linkedHashSet.add(21);
        linkedHashSet.add(31);
        linkedHashSet.add(71);
        linkedHashSet.add(91);

        // Displaying the LinkedHashSet
        System.out.println("LinkedHashSet: " + linkedHashSet);

    }
}
