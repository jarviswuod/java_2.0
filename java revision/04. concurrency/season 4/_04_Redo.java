/*

    NOTES:
    - Muiltitasking
        - Refers to act of a computer handling more than one task concurrently

    - Types of multitasking:
        - Process-based multitasking:
            - Refers to running multiple apps/programs concurrently

        - Thread based mulitasking:
            - Refers to a program running in multiple threads concurrently

    - Difference between Thread and process:
        - Thread share the same memory address space
        - COntext switching between threads is relatively easy
        - Connunication cost across Threads is fairy cheap

    - Why Multithreading:
        - To make good use of CPU clock cycle and minimize


    -----------------------------------------------------------

    - Threads:
        - Refers to independent sequential path of execution of a program

    - 3 concepts to learn about threads:
        - Thread creation and code execution
        - Sharing data between threads via synchronization
        - Different stages of Thread/ Thread lifecycle

    - How to create threads:
        - Using the runnable inteface
        - Using the thread class

    - Daemon and user thread:
        - JVM can decide to end up an daemon thread if there;s no user thread
        - JVM doesnot terminate wherenever we still have an active user thread running


    -----------------------------------------------------------
    - Thread creation
    - Extending the thread class
    - defiing the run()
    - start() method is an asyncrhonous method that returns immdeiately then it's now time for JVM to decide what thread runs at what time

    - Supplying thread name
    - Using the runnable interface



    -----------------------------------------------------------
    - Sychronization:
        - synchronized
        - One true method synchronization:
            - public synchronized void add() {...}

        - Static synchronized:
            - synchronized (ClassName.class) {...}

        - This synchronized:
            - synchronized (this) {...}

        - Multiple synchronized
            - synchronized (lock1) {...}
            - synchronized (lock2) {...}

        - no synch
    - Object lock = new Object();

 */

public class _04_Redo {

}
