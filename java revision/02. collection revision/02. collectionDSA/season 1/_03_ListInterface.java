/*

    NOTES:
    - List implementations:
        - ArrayList
        - LinkedList
        - Vector

    - List Methods:
        - get(index)
        - set(index, element)
        - add(index, element)
        - addAll(index, Collection c)
        - remove(index)
        - indexOf(element)
        - lastIndexOf(element)
        - subList(startPos, endPos) -> Does Shallow copy

    - LinkedList vs ArrayList
        - doubly linked list, dynamic array internally
        - fast manunipation, slow manupulation
        - not great for storing, good for storing
        - Queue, Deque and List, List only
        - More memory(element, prev and next ref), less memory

    - ArrayList
        - Creating an ArrayList:
            - new ArrayList<>() -> Using default way
            - new ArrayList<>(Collection c) -> Using Collections

    - Vector(legacy dynamic array):
        - Unlike the ArrayList class, the Vector class is thread-safe, i.e concurrent calls to the Vector will not compromise it's integrity
        - Vectors suffer a slight perfomance penalty due to synchronization to ArrayList

 */

public class _03_ListInterface {

}