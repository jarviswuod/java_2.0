/*

    NOTES:
        - We have a queue and 2 groups of threads, One group of threads is trying to add item to the queue, the other group of threads is trying to remove items from the queue
        - We can only push items to the queue if it doesnotc increase the capacity and we can pull items in the queue (Like in the stack class example) if there is an item left in the queue.
        - Breakdown;
            - Multiple threads adding items to the queue
            - Multiple threads removing items to the queue
 
        - Code Explanation:
            - Since multiple threads are trying to access our queue, we introduce the synchronize block:
                - synchronized (q) {...}

            - We have the option of using 'this' as our lock but we will use 'q' since an object of the Queue class
            - Since we introduced the 'synchronize' keyword only one thread is allowed to access either of the methods
            - We add a check condition to both the add() and remove() methods
            - What will happen if a thread of the remove threads group gets access to the remove() method; 
                - All other threads will be blocked irrespective of the group and it will get access to the if() loop, keep in mind there's no item in the queue. Here is the thing, the thread has the lock to the synchronize remove() and has the ability to execute(other threads are blocked) but it cannot execute because the queue has no item to be removed of it, the size of the queue is zero
                - In this case thread has to 'wait' for a condition and the condition is until any other thread adds item in teh queue and only then will there be an item to be removed of the Queue
                    - q.wait();

                            - Object class has access to 3 methods that we can use, i.e (The methdods are already inherited to any class that inherits the Object class inclusive of our Queue class)
                                - wait()
                                - notify()
                                - notifyAll()

                - When the thread calls the wait() method, other threads get a chance to be executed. It's waiting until the time when an item is added to the queue, this will happen when it's notified that an element has been added. This notification has to be triggered when an element is added via the add() method
                    - q.notifyAll();

                -  We make it notify all because we want to notify all the threads in the wait state of the remove() method that an item has been added

                - We do the same thing in the add() method if() stament too, to wait until an element has been removed from the queue, creating a space to add more items.

            - Since we had multiple remove and add threads, imagine a situation where multiple add threads had the chance to be executed but were not able to because, the size was already set to maximum, hence they were set to wait() method. If by any chance we have a single element removed in the stack, all the threads that were waiting will be triggered by the q.notifyAll() method. This leads to a condition where we have say 3 threads that are to be now executed, keep in mind only one slot was left, We have to have a methodology of always checking if the queue is full every single time we have notifyAll() method called. This prevent any potential issues that might arise, hence;
                - while (q.size() == capacity) {...}
                - while (q.size() == 0) {...}
            
            - After replacing if() with while() we ensure that the conditions are always checked by all threads before execuing preventing any errors

 */

import java.util.LinkedList;
import java.util.Queue;

public class _07_ProducerConsumerPattern {
    public static void main(String[] args) {

    }
}

class BlockingQueue {
    private Queue<Integer> q;
    private int capacity;

    public BlockingQueue(int cap) {
        q = new LinkedList<>();
        capacity = cap;
    }

    public boolean add(int item) {
        synchronized (q) {
            // if (q.size() == capacity)
            while (q.size() == capacity)
                try {
                    q.wait(); // adder1, adder2, adder3
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            q.add(item);
            q.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (q) {
            // if (q.size() == 0)
            while (q.size() == 0)
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            int element = q.poll();
            q.notifyAll();
            return element;
        }
    }

}