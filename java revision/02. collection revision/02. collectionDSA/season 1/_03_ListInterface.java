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

    ArrayList:
        - Creating an ArrayList:
            - new ArrayList<>() -> Using default way
            - new ArrayList<>(Collection c) -> Using Collections

    ListIterator:
        - next() -> return items[index ++];
        - previous() -> return items[-- index];
        - hasNext()
        - hasPrevious()

    toArray() method:
        - toArray(new Integer[0])
            - You can pass the same size as the arrayList to be converted
            - If you pass a bigger value than the ArrayList, the values will be copied and the remaining spots will be null, NOT a good convention
            - BEST PRACTISE - If you pass a small size than the ArrayList length, then a new Array is created with exactly the same length as the ArrayList
            - Example:
                - Integer[] arr = alist.toArray(new Integer[0]);

 */

public class _03_ListInterface {

}