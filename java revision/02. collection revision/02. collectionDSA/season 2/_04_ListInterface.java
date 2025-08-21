/*

    NOTES:
    - Features/properties:
        - Can contain duplicates
        - Maintain insertion order
        - indexing start from 0 just like in arrays
        - can contain multiple null values


    - Methods:
        - add(element)
        - get(element)
        - set(index, element)
        - clear()
        - isEmpty()
        - size()
        - indexOf(element)/ lastIndexOf(element)
        - remove(element or index)
        - subList(start, end) -> shallowcopy
        - contains()
        - containsAll()
        - removeAll()
        - retainAll()
        - addAll()


    - Types:
        - ArrayList<Integer>
        - LinkedList<Integer>
        - Vector<Integer>


    - Creating ArrayList:
        - default constructor; new ArrayList<>();
        - parametized constructor; new ArrayList<>(Collection c);
        - add all method; list.addAll(Collection c);


    - ArrayList vs LinkedList
        - small in size, only element stores --> relative bigger, element, next and previous refe
        - Dynamic array slow from shifts, doubly linked List, hence fast in manipulation(removing and inserting)
        - Implements only List, hence only used as list, can be used as Queue or list, implmenets both list, queue and deque

 */

public class _04_ListInterface {

}
