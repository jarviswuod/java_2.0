/*

    NOTES:
     - The Deque interface extends the Queue interface to allow double-ended queues
     - It allows operations not just at it's head, but also at it's tail
     - Elements can be inserted at or removed from either end
     -  A deque can be used as FIFO queue, where elements added at tail are presented at the head for inspection or removale in the same order, thus implementing FIFO Order


     - You can use Deque as either a LIFO or  FIFO
     - Instead of using a Stack go for a Deque
     - For a normal que too you can also use Dequeue or also use a LinkedList for it as well
     - ^^ Reason, LinkedList also implements a queue


    Deque methods:
     - ADDING:
         - boolean offerFirst(E element)
         - boolean offerLast(E element) Queue equivalent: offer()
         - void push(E element) Synonym: addFirst()
         - void addFirst(E element)
         - void addLast(E element) Queue equivalent: add()

     - REMOVING:
         - E pollFirst() Queue equivalent: poll()
         - E pollLast()
         - E pop() Synonym: removeFirst()
         - E removeFirst() Queue equivalent: remove()
         - E removeLast()

     - EXAMINE:
         - E peekFirst() Queue equivalent: peek()
         - E peekLast()
         - E getFirst() Queue equivalent: get()
         - E getLast()

 */

/*
    DEQUE Implementations
     - ArrayDeque and the LinkedList class Implement the Dequeu interface
     - Whenever you want to implement FIFO order, ArrayDeque class is always the way to go(Stack)
     - Whenever you need a normal queue, LinkedList works perfect

 */

public class _07_DequeInterface {

    public static void main(String[] args) {

    }
}
