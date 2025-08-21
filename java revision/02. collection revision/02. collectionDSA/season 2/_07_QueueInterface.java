/*

    NOTES:
    - PriorityQueue:
         - Comparable -> compareTo()
            - 1 more param to compare to
            - non customizable as we are the clients
            - PriorityQueue<Integer> priority1 = new PriorityQueue<>();
            - PriorityQueue<Integer> priority2 = new PriorityQueue<>(new ComparatorClass());
            - PriorityQueue<Integer> priority3 = new PriorityQueue<>((a, b) -> a.getMath() - b.getMath());


       - Comparator -> compare()
            - class, lambda expression
            - 2 more params to compare to against
            - customizable to whatever order we want
            - PriorityQueue<Student> priority4 = new PriorityQueue<>(studentList);
            - PriorityQueue<Student> priority5 = new PriorityQueue<>(new ComparatorClass());
            - PriorityQueue<Student> priority6 = new PriorityQueue<>((a, b) -> a.getMath() - b.getMath());


    - LinkedList:
        - offer() -> add last element
        - poll() -> remove first element
        - peek() -> see first element

    - Stack:
        - push() -> add last
        - poll() -> remove and return last added element
        - peek() -> see last added element

    - ArrayDeque:
        - addFirst(), offerFirst(), offer(), add()
        - addFirst(), removeFirst(), offerLast(), pollLast(), poll(), remove()
        - getFirst(), getLast(), peek(), peekFirst(), peekLast(), get()

 */

public class _07_QueueInterface {
}