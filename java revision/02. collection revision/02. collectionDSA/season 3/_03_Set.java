/*

    NOTES:
    - Set:
        - HashSet;;; Unordered Set
        - LinkedHashSet;;; keeps insertion order, not sorted
        - TreeSet <- NavigableSet <- SortedSet;;; auto-sorted

    - LinkedHashSet:
        - Faster than TreeSet but slower than Hashset
        - Combines both LinkedList and HashSet
        - Maintains insertion order

    - Vital rule
        - Code against the interface, not the concrete class

    - Set Features:
        - No duplicate allowed
        - Only one single'null' element
        - No single insertion order maintained

    - Utility methods
        - addAll(Collection c)
        - removeAll(Collection c)
        - retainAll(Collection c)
        - containsAll(Collection c)

    - Set Methods:
        - add(element)
        - remove(element)
        - contains(element)
        - isEmpty()
        - clear()
        - size()

    - Sorted methods
        - first()
        - last()
        - headSet()
        - lastSet()
        - subSet()

    - Navigable methods
        - pollFirst()
        - pollLast()
        - descendingSet()
        - descendingIterator()

    - TreeSet methods: sorted Set
        - higher(element)
        - lower(element)
        - cealing(element)
        - floor(element)

    - Iterator Methods:
        - next()
        - hasNext()
        - remove()

    - Sorting Set: convert to List collection first
        - comparable; natural ordering: compare(arg0)
        - comparator; total ordering: compareTo(arg0, arg1)

        - Collections.sort(Collection c)
        - Collections.sort(Collection c, (a, b) -> a - b);
        - Collections.reverse()

    - Looping through Sets:
        - Iterator for loop
        - Iterator while loop
        - Enhanced for loop
        - forEach loop
        - stream.forEach

 */

public class _03_Set {
}