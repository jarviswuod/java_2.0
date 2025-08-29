/*

    NOTES:
    - Creating a Queue;
        - default way : new ArrayDeque<>();
        - Via collections: new ArrayDeque<>(Collection c);
        - via addAll(Collection c) method

    - Queue features:
        - Allows duplicate
        - maintains insertion order
        - Allows multiple null elements

    - Queue methods:
        - add(element)
        - addAll(Collection c)
        - remove(element)
        - removeAll(Collection c)
        - retainAll(Collection c)
        - set(index, element)
        - get(element or index)
        - contains(element)
        - isEmpty()
        - peek())))))
        - poll())))))
        - offer())))))

    - Iterating a Queue:
        - basic for loop:

        - enhanced for loop:

        - for iterator:

        - while iterator:

        - forEach():

        - stream.foreach():

    - Diff btwn LinkedQueue vs Deq
      - Internally uses doubly Linked Queue to store elements, internally uses dynamic array to store elements
        - Fast in data manipulation(delete, update), Not fast because elements have to be manually adjusted every time
        - , good for storage of data
        - larger in side as it stores data plus refs to both prev and next elements, relatively smaller in size compared to LinkedQueue

 */

public class _04_Queue {

}
