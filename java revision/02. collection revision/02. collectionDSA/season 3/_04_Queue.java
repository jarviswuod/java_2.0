/*

    NOTES:
    - Queue Type:
        - PriorityQueue
        - Deque:
            - ArrayDeque
            - LinkedList

    - Queue Methods:
        - offer()
        - peek()
        - poll()
    
    - Deque:
        - Allows adding and removing elements from either point of the Deque

        - Deque Methods:
            - offer(), offerFirst(), offerLast(); applies to add()
            - peek(), peekFirst(), peekLast(); applies to get()
            - poll(), pollFirst(), pollLast(); applies to remove()


    - vital rule
        - code against the interface, not the concrete class

    - Queue Features:
        - Allow duplicate
        - Allow multiple 'null' elements
        - Follows First In First out
        - Insertion order maintained

    - Queue Methods:
        - add(element)/ offer()
        - remove(element)/ poll()
        - get()/ peek()
        - contains(element)
        - isEmpty()
        - clear()
        - size()

    - Utility methods
        - addAll(Collection c)
        - removeAll(Collection c)
        - retainAll(Collection c)
        - containsAll(Collection c)
        - Collections.sort(Collection c)
        - Collections.reverse(Collection c)

    - Iterator Methods:
        - next()
        - hasNext()

    - ListIterator Methods:
        - next()
        - hasNext()
        - previous()
        - hasPrevious()

    - Sorting List: convert to List collection first
        - comparable; natural ordering: compare(arg0)
        - comparator; total ordering: compareTo(arg0, arg1)

        - Collections.sort(Collectino c)
        - Collections.sort(Collectino c, (a, b) -> a - b);
        - Collections.reverse()

    - Looping through Lists:
        - basic for loop
        - Iterator for loop
        - Iterator while loop
        - Enhanced for loop
        - forEach loop
        - stream.forEach

 */

public class _04_Queue {
}