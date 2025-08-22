/*

    NOTES:
    - synchronized keyword:
        - While a thread is inside a synchronized method of an object, all other threads that wish to execute this synchronized method or any other synchronized method of the object will have to wait
        - This restriction does not apply to a thread that already has the lock and is executing on a synchronized method of the object
        - Such a thread can invoke other synchronized methods of the object without being blocked
        - The non-synchronized methods of the object can always be called at any time by any thread


    - Rules of Synchronization:
        - A thread must acquire the object lock associated with a shared resource before it can enter the shared resource
        - The runtime system ensures that no other thread can enter a shared resource if another thread already holds the object lock associated with it
        - If a thread cannot immediately acquire the object lock, it is blocked, i.e, it must wait for the lock to become available
        - When a thread exits a shared resource, the runtime system ensures that the object lock is also relinquished. If another thread is waiting for this object lock, it can try to acquire the lock in order to gain access to the shared resource
        - It should be made clear that programs should not make any assumptions about the order in which threads are granted ownership of a lock


    - Thread.sleep();
        - This sleep() method increases the chances for the state of the stack begin corrupted by one of the thread while the other one is sleeping


    - Static Synchronized Methods:
        - A thread acquiring the lock of a class to execute a static synchronized method has no effect on any thread acquiring the lock on any object of the class to execute a synchronized instance method
        - In other words, synchronization of static methods in a class is independent from synchronization of instance methods on object of the class
        - A subclass decides whether the new definition of any inherited synchronized method will remain synchronized in the subclass


    - Race Condition:
        - It occurs when two or more threads simultaneously update the same value(StackTop) and, as a consequence, leave the value in an undefined or inconsistent state


    - Synchronized Blocks:
        - Whereas execution of synchronized methods of an object is synchronized on the lock of the object, the synchronized block allows execution of an arbitrary code to be synchronized on the lock of arbitrary object.
        - The general form of the synchronized statement is as follows:
            - synchronized(object ref expression) {...}

        - The object ref expression must evaluate to a non-null reference value, otherwise a NullPointerException is thrown


    - Summary:
        - A thread can hold a lock on an object:
            - By executing a synchronized instance method of the object. (this)
            - By executing the body of a synchronized block that synchronizes on the object. (this)
            - By executing a synchronized static method of a class or a block inside a static method(in which case the object is the Class object representing the class in the JVM)


    - Thread Safety:
        - It's the term used to describe the design of classes that ensure that the state of their objects is always consistent, even when the objects are used concurrently by multiple threads, E.g StringBuffer

 */

public class _05_SynchronizationNotes {
    public static void main(String[] args) {

        System.out.println("Main is starting ...");

        Stack stack = new Stack(5);

        new Thread(() -> {
            int counter = 0;
            while (++counter < 10)
                System.out.println("Pushed " + stack.push(100));
        }, "Pusher").start();

        new Thread(() -> {
            int counter = 0;
            while (++counter < 10)
                System.out.println("Popped " + stack.pop());
        }, "Popper").start();

        System.out.println("Main is exiting ...");
    }
}

class Stack {
    private int[] array;
    private int stackTop;

    public Stack(int capacity) {
        array = new int[capacity];
        stackTop = -1;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    public synchronized boolean push(int element) {
        if (isFull())
            return false;
        ++stackTop;

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        array[stackTop] = element;
        return true;
    }

    public synchronized int pop() {
        if (isEmpty())
            return Integer.MAX_VALUE;

        int obj = array[stackTop];
        array[stackTop] = Integer.MIN_VALUE;

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        stackTop--;
        return obj;
    }
}