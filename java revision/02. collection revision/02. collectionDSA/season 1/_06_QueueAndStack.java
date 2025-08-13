/*

    NOTES:
    - Queue interface:
        - Queue Methods:
            - add(element)/ offer(element)
            - remove()/ poll()
            - element()/ peek()

        - Safe Methods:
            -  offer() to add elements
            -  poll() to delete elements
            -  peek() to see if elements exist

    - Stack interface:
        - Stack methods:
            - push()
            - peek()
            - pop()

 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _06_QueueAndStack {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        System.out.println(queue);
        System.out.println(deque);
        System.out.println(stack);
    }
}