/*

    NOTES:
    - Queue
        - Meaning:
            - First in, first out


        - Queue interface:
            - Ordering Queue:
                - PriorityQueue<>()
                    - Natural ordering using comparable interface compareTo() method


            - LinkedList<>();

            - Deque
                - Deque<Integer> arrayDeque = ArrayDeque<>();
                - Deque<Integer> linkedList = LinkedList<>();


    - Stack
        - Meaning:
            - Last in, First out


        - Intro:
            - Stack<Integer> list = new Stack<>();

        - Stack methods:
            - push();
            - poll();
            - peek();

    - 



 */

import java.util.PriorityQueue;

public class _06_QueueAndStack {

    public static void main(String[] args) {

        PriorityQueue<Integer> list = new PriorityQueue<>();
        list.offer(12);
    }
}
