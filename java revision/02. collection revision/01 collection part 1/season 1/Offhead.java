/*

    List
        - ArrayList
        - LinkedList

    Set
        - HashSet
        - TreeSet

    Map
        - HashMap
        - Hashtable
        - TreeMap
 
    Creating List
        - Using default constructor
                List<Integer> list1 = new ArrayList<>();
        - Using another collection constructor
                List<Integer> list2 = new ArrayList<>(list1);
        - Using .addAll()
                List<Integer> list3 = list1.addAll(list2);

    Methods I can think
        .add(elementName) -> anything else(Set, List, Queue)
        .put(key, value) -> for Maps
        .get(index)
        .remove(index or elementName) -> doesnot work for String Integer
        .removeAll(Collection c)
        .clear()
        .size()
        .contains(elementName)
        .set(index, elementName)

        .addFirst(elementName)
        .addLast(elementName)
        .removeLast(elementName)
        .removeFirst(elementName)

        .indexOf(elementName)
        .lastIndexOf(elementName)

    List
        Allow duplicate elements
        Allow duplicate null values
        Maintains insertion order
        Elements are indexed like in array from 0

    Set
        Duplicates are not allowed
        Null values are not allowed
        insertion order is not maintained
        indexOf is not allowed/avaiable

    Map Methods
        .keySet()
        .entrySet()
        .getKey()
        .getValue()
        .iterator()
        .values()
        .get()
        .getValue()

    Iteration
        basic for loop
        ForEach loop
        stream
        while
        iterator for loop

    LinkedList vs ArrayList
        doubly linked list, dynamic array internally
        fast manunipation, slow manupulation
        not great for storing, good for storing
        Queue and List, List only
        more memory(element, prev and next ref), less memory

    Sorting
        Custom sorting -> using Comparator
        Order using Collections.sort() ... Collections.reverse()


 */

public class Offhead {

    public static void main(String[] args) {

    }
}
