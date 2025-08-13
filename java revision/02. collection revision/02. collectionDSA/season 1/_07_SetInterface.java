/*

    NOTES:
    - Set:
        - Sets: The Set interface extends the Collection interface
        - Sets does not allow duplicate elements
        - Sets Methods:
            - containsAll(Collection<? extends E > c) (subset)
            - addAll(Collection<? extends E > c) (union)
            - removeAll(Collection<?> c) (difference)
            - retainAll(Collection<?> c) (intersection)
            - clear() (empty the set)


        - Implementation of Set:
            - HashSet
            - LinkedHashSet
            - TreeSet


    - HashSet:
        - Methods:
            - Basic Set:
                - add(elementName)
                - remove(elementName)
                - contains(elementName)
                - addAll(Collection c)
                - removeAll(Collection c)
                - retainAll(Collection c)
                - containsAll(Collection c)
                - size()
                - isEmpty()
                - clear()

            - Iteration:
                - iterator()
                - spliterator()
                - forEach(Consumer)

            - Array ops:
                - toArray()
                - toArray(T[])


        - Methods in action:
            Set<Integer> A = new HashSet<>(List.of(1, 2, 3, 4));
            Set<Integer> B = new HashSet<>(List.of(3, 4, 5, 6));

                - A.containsAll(B); // false → A doesn't have 5, 6
                - A.addAll(B); // A becomes [1, 2, 3, 4, 5, 6]
                - A.removeAll(B); // A becomes [1, 2] (removes 3, 4, 5, 6)
                - A.retainAll(B); // A becomes [3, 4] (keeps only common)


        - NOTE:
            - B always remains unchanged
            - In a hashset the deletion & addition take the same amount of time, O(1) on average
            - HashSet is not ordered, so the order of elements may change
            - HashSet cannot be sorted
            - HashSet does not allow duplicate elements


    - Custom HashSet
            - Whenever you insert an element into a HashSet, a hashcode for that element is being generated and then mapped to a particular bucket and then from the bucket it checks the hashcode of all other elements. If it finds a match, it checks the equals() method to see if the content is same or not.
                2 things happen here:
                    - 1. If the hashcode matches, it checks the equals() method
                    - 2. If the hashcode does not match, it will not check the equals() method and will just insert the element into the HashSet
            - If you don't override equals() and hashcode() methods, the default implementation will be used which is based on the memory address of the object. This means that even if two objects have the same content, they will be considered different if they are not the same object in memory.
            - If you override equals() method, you must also override hashcode() method to maintain the contract between equals() and hashcode() methods. If two objects are equal according to equals() method, they must have the same hashcode.

            - contains() process:
                - hashcode: -> Memory address of the object
                - equals: -> Compares the content of the object/reference

        - KEY:
            - Always override equals() and hashcode() of your custom class before using it in a HashSet



    - LinkedHashSet:
        - Ex
            - Set<Integer> hashSet = new HashSet<>();
            - Set<Integer> linkedHashSet = new LinkedHashSet<>();

        - Is a combination of HashSet and LinkedList
        - It maintains the insertion order of elements
        - It is slower than HashSet but faster than TreeSet
        - It uses a doubly linked list to maintain the order of elements
        - Useful when you want to maintain the order of elements while still having the benefits of a HashSet


    - TREESET:

        - Methods:
            - Basic Set ops: 
                - add()
                - remove()
                - contains()
                - size()
                - isEmpty()
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

            - TreeSet ops:
                - floor()
                - ceiling()
                - lower()
                - higher()


        - TreeSet Methods:
            - ceiling() → least element >= given value
            - higher() → least element > given value

            - floor() → greatest element <= given value
            - lower() → greatest element < given value

        - The above methods do not work with Set class hence could not work with set1 in the example below
        - They only work under NavigableSet interface as they part of the methods



    - CustomTreeSet:
        // Set<StudentsMarks> treeset = new TreeSet<>(); // By default it sorts based on
        // math marks
        Set<StudentsMarks> treeset = new TreeSet<>((s1, s2) -> s2.getPhysics() - s1.getPhysics());


 */

public class _07_SetInterface {

}