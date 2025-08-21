/*

    NOTES:
    - Features/properties:
        - No duplicates
        - ONLY one null value
        - No insertion order maintained
        - No indexing


    - Methods:
        - Set:
            - add(element)
            - isEmpty()
            - size()
            - remove(element)
            - contains()
            - containsAll()
            - removeAll()
            - retainAll()
            - addAll()
            - clear()

        - SortedSet ops: 
            - first()
            - last()
            - headSet()
            - tailSet()
            - subSet()

        - NavigableSet extras: 
            - pollFirst()
            - pollLast()
            - descendingSet()
            - descendingIterator()

        - TreeSet:
            - ceiling() → least element >= given value
            - floor() → greatest element <= given value
            - higher() → least element > given value
            - lower() → greatest element < given value


    - Types:
        - HashSet<Integer>
        - LinkedHashSet<Integer>
            - Insertion order
            - implement both LinkedList and HashSet
            - slower than HashSet but faster than Treeset

        - TreeSet<Integer> <- Navigable interface <- Sorted Interface


    - Creating Set:
        - default constructor; new HashSet<>();
        - parametized constructor; new HashSet<>(Collection c);
        - add all method; list.addAll(Collection c);


    - Custom HashSet
        - Always override equals() and hashcode() of your custom class before using it in a HashSet

 */

public class _08_Sets {
}