/*

    NOTES:
    - Deque Intro:
        - Deque extends the Queue interface to allow double-ended queues
        - Elements can be inserted at or removed from either end

        - You can use Deque as
            - LIFO (Stack) -> Last In First Out
            - FIFO (LinkedList) -> First Out First Out

    - DEQUE Implementations
        - ArrayDeque
        - LinkedList

    - Deque methods:
        - ADDING:
            - addFirst(element) / offerFirst(element) / push(element)
            - add() / offer() / addLast(element) / offerLast(element)

        - REMOVING:
            - removeFirst() / pollFirst() / pop()
            - remove() / poll() / removeLast() / pollLast()

        - EXAMINE:
            - getFirst() / peekFirst()
            - element() / peek() / getLast() / peekLast()

 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _07_Deque {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        System.out.println(queue);
        System.out.println(deque);
        System.out.println(stack);
    }
}