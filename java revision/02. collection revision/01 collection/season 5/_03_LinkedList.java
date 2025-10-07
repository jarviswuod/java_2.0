/*

    NOTES:
    - Queue:
        - 


    - Creating a LinkedList:
        - Using default constructor
            - Queue names = new LinkedList<>();

        - Using another collection
            - Queue names = new LinkedList<>(Collection c);

        - Using addAll() method
            - Queue names = names.addAll(Collection c);


    - Queue methods:
        - offer()
        - poll()
        - peek()


    - Dequeue methods:
        - ADDING ELEMENTS
            - offer() / offerFirst() / offerLast()
            - add() / addFirst() / addLast()


        - REMOVING ELEMENTS
            - remove() / removeFirst() / removeLast()
            - poll() / pollFirst() / pollLast()


        - ACCESSING ELEMENTS
            - peek() / peekFirst() / peekLast()
            - get() / getFirst() / getLast()


 */

import java.util.ArrayDeque;
import java.util.Deque;

public class _03_LinkedList {
    public static void main(String[] args) {

        Deque<String> names = new ArrayDeque<>();
        names.offer("Jarvis");
        names.offer("Wuod");
        names.offer("Name");
    }
}
