/*

    NOTES:
    - Queue methods (FIFO): -----------------------------> LinkedList class
        - offer() -> adds to last
        - peek() -> views first
        - poll() -> removes first

    - Stack methods (LIFO): -----------------------------> Stack class
        - push() -> adds to last
        - peek() -> views last
        - pop() -> removes last

    - Deque methods (Double-ended): ---------------------> ArrayDeque class
        - offerFirst() -> adds to first
        - pollFirst() -> removes first
        - peekFirst() -> views first without removing

        - offerLast() -> adds to last
        - pollLast() -> removes last
        - peekLast() -> views last without removing
            
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _08_AllQueueMethods {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();

        System.out.println(queue);
        System.out.println(stack);
        System.out.println(deque);
    }
}