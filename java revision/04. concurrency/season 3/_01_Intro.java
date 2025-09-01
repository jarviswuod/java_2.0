/*

    NOTES:
    - 3 important thread concept:
        - Creating Threads and code to be executed at run time
        - Concurrent thread execution and Accessgin shared data and code through synchronization
        - Transitioning btwn Thread states

    - Multitasking;
        - Types;
            - process-based mulitasking
                - Handing more than concurrent task by a computer, say using 2 apps at the same time

            - thread-based mulitasking
                - Running multiple threads at the same time for a given task withing computer, example; word writing and spelling check

        - Difference btwn process-based and thread-based multitasking;
            - Threads tends to share the same memory address
            - Context switching btwn threads is relatively smooth and less expensive as it's in the same memory address
            - Cost of communication btwn threads is faster and relatively low as the threads are in the same memory address
        
    - Types of Threads;
        - user threads
        - daemon threads; setDaemon(true)/ setDaemon(false)

    - Why multithreading;
        - To maximize resource usage by the computer(CPU cycles)

    - Ways of achieving multithreading;
        - Extending Thread class
        - Implementing the Runnable interface

        - Why is it possible;
            1. We have the option to override the run() {} by extending the class, we ovveride with the code we want to execute
            2. We pass a valid Runnable instance to the run method, ensuring we execute the underlying block code


    - Including a custom name to Thread
        - For Runnable;
            - Thread t1 = new Thread(new Runnable(), "thread1");

        - For exending Thread Class;
            - Thread t2 = new ThreadClass("thread2");

            class ThreadClass extends Thread() {
                public ThreadClass(String name) {
                    super(name);
                }
            }
        - Thread.currentThread().getName();

    - synchronized keyword
        - sync block
        - sync method

        - Types/formats to achieve sync states;
            - Single sync;
                - Object lock = new Object();

                synchronized(this) {  // lock
                    // code block
                }

            - multi sync;
                - Object lock1 =  new Object();
                - Object lock2 =  new Object();

                synchronized(lock1) {  // lock
                    // code block
                }

                synchronized(lock2) {  // lock
                    // code block
                }
                
            - static block sync;

                synchronized(ClassName.class) {  // lock
                    // code block
                }

    - volatile keyword
        - 2 Threads have different cpu but share the same RAM, we introduce caching as its easy to access data from cache than making direct reference to RAM
        - If a shared value is updated by any of the threads, it doesnot directly reflect on the other one, it takes for update to travel from it's cache to the shared RAM and more time to the other thread's cache
        - To prevent any data incosisteny among the shared values, we introdue volatile keyword.
        - This means, we have to read and update the value directly from te RAM and not threads specific cache, increasing data integrity in the program
        - Sample;
            - private boolean flag = true;
            - private volatile boolean flag = true;

    - Race condition
        - It occurs when two or more threads simultaneously update the same value(StackTop) and, as a consequence, leave the value in an undefined or inconsistent state

    - Dead lock
        - Is a condition where one Thread is waiting for a lock release from another thread to execute and the second thread is waiting for lock currently held by the first Thread

    - Producer Consumer Pattern
        - Multiple threads groups; add, remove 
        - while (q.size() == 0)

    - Thread priorities
        - setPriority() any value from 1 - 10
        - getPriority()

        - MIN_PRIORITY
        - MAX_PRIORITY

    - Thread scheduler
        - Thread scheduler decides which thread runs when. JVM schedulers typically use:
            - Preemptive scheduling;
                - setPriority(10)
            - Time-sliced or round-robin scheduling;
                - yield()

    - Timed Out VS Interrupted:
        - In Interrupted you get to know a thread got Interrupted by some other thread but in timeout you don't know if the thread got timeout or got notified

    - Thread safety
        - It's the term used to describe the design of classes that ensure that the state of their objects is always consistent, even when the objects are used concurrently by multiple threads, E.g StringBuffer

    - Thread methods;
        - start()
            - This method does not start immediately, it's an asynhronous method that returns immediately. It's now upto JVM to start the Thread execution when it wants to

        - join()
            - This methods pauses other concurrent threads executing for it's execution to be complited first before proceeding with other thread execution,
            - Example;
                - Pausing on main Thread to completely execute child thread
            - 3 conditions to stop execution;
                1. Time elapse on executionn time set ealier
                2. Successfully completting execution
                3. Interrupted by another thread;
                    - Raises the exception immediately

        - sleep()
            - This method "paused" execution on current Thread for a specified duration, It however doesnot release it's 'lock' key object
            - 2 conditions to stop execution;
                1. Sleep time elapsing
                2. Interrupted by another thread

        - wait()
            - This method releases 'lock' object to the Thread scheduler until it's notified by another set of thread that a condition is meet
            - 3 Conditions for waking up;
                - Notified by another thread
                - Interrupted by another thread

            - NOTE:
                - When the thread is notified or interrupted, it doesnot execute immediate, it has to wait to be assigned the 'lock' object key by the scheduler to begin execution

        - notify()
            - Only notifies a single thread that a condition has been meet and it can continue with it's execution

        - notifyAll()
            - Notifies multiple threads that a condition has been meet and they can continue with there executions

        - yield()
            - This method tells the thread executor to pause on this current thread and pick another thread to execute instead, i.e assign priority to a different thread
            - Thread executor however has no objeligation of following the request

 */

public class _01_Intro {
    public static void main(String[] args) {
        Thread t1 = new Thread();

    }
}
