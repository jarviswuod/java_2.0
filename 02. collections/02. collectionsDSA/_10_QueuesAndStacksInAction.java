/*

    NOTES:
      - Normal queue(FIFO), use LinkedList class to instantiate it
      - For stacks use stack class



    METHODS to keep in mind as per example:
    - Queue (FIFO): -----------------------------> LinkedList class
        - offer() -> adds to end
        - peek() -> views front
        - poll() -> removes front

    - Stack (LIFO): -----------------------------> Stack class
        - push() -> adds to top
        - peek() -> views top
        - pop() -> removes top

    - Deque (Double-ended): ---------------------> ArrayDeque class
        - offerFirst() -> adds to front
        - pollFirst() -> removes front
        - peekFirst() -> views front without removing


        You can use an ArrayDeque to implement a normal queue (FIFO) as well as stack (LIFO) but we dont do that, because we already have a linkedlist that solves our normal FIFO queue issues and we have stack to solve LIFO issue but since in ArrayDeque we can add elements basically anywhere, front, back, middle position. We only use ArrayDeque for double-ended queue

 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _10_QueuesAndStacksInAction {

    public static void main(String[] args) {

        System.out.println("---- Queue is starting here ----");
        // FIFO queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(11);
        queue.offer(22);
        queue.offer(33);

        System.out.println(queue); // [11, 22, 33]
        System.out.println(queue.peek()); // 11: front of queue
        System.out.println(queue.poll()); // removes and returns 11
        System.out.println(queue.peek()); // 22: new front
        System.out.println(queue); // [22, 33]

        System.out.println("---- Stack is starting here ----");
        // LIFO queue
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);

        System.out.println(stack); // [11, 22, 33, 44]
        System.out.println(stack.peek()); // 44
        System.out.println(stack.pop()); // removes and returns 44
        System.out.println(stack.peek()); // 33
        System.out.println(stack); // [11, 22, 33]

        System.out.println("---- Deque is starting here ----");
        // Double-ended queue
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offerFirst(11); // adds 11 to front
        deque.offerFirst(22); // adds 22 to front
        deque.offerFirst(33); // adds 33 to front
        System.out.println(deque); // [33, 22, 11]

        System.out.println(deque.pollFirst()); // 33 -> removes 33 from the front
        System.out.println(deque.peekFirst()); // 22 -> views front without removing
        System.out.println(deque); // [22, 11]

        deque.offerLast(100); // adds 100 to bottom
        deque.offerLast(200); // adds 200 to bottom
        deque.offerLast(300); // adds 300 to bottom
        System.out.println(deque); // [22, 11, 100, 200, 300]

        System.out.println(deque.pollLast()); // 300 -> removes 300 from the bottom
        System.out.println(deque.peekLast()); // 200 -> views bottom without removing
        System.out.println(deque); // [22, 11, 100, 200]

    }
}