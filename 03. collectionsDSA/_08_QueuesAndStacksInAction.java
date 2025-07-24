/*


    NOTES:
      - For stacks use stack class
      - Normal FIFO queue, use LinkedList class
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _08_QueuesAndStacksInAction {

    public static void main(String[] args) {

        System.out.println("-------- Queue is starting here --------");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(11);
        queue.offer(22);
        queue.offer(33);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        System.out.println(queue.isEmpty());

        System.out.println("-------- Stack is starting here --------");
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }

        System.out.println("-------- Deque is starting here --------");
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offerFirst(11);
        deque.offerFirst(22);
        deque.offerFirst(33);
        System.out.println(deque);

        deque.pollFirst();
        deque.peekFirst();
        System.out.println(deque);
    }
}
