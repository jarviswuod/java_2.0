/*

    RANDOM THREADS NOTES(OFFHEAD):
    - synchronize(this)
    - you can synchronize either the whole method, or just synchronize a specific block set
    - Object lock; = new Object();
    - singleton
    - multithreading priorities
    - multithreading scheduler
    - yield()
    - wait()
    - join()
    - sleep()
    - 

    - Creating threads:
        - Threads keyword; not prefered because you can only extend one class
        - Runnable keyword; use this because you can implement multiple interfaces
        - Passing thread names and accessing the names
        
    - join()
        - pauses the concurrent/ asynchronous running of a thread and waits until one is done before it can proceed
        - 3 conditions;
            - interrupted
            - time elapse
            - done task

    - sleep()
        - Does not handle the 'lock' meaning JVM scheduler cannot assing any other thread
        - after time elapse or if disrupted by another thread,
        - Does not throw exception instantly it still has to wait to be assigned a 'lock' by JVM then it throws an error(SAME concept applies to all other thread methods)


    - wait()
        - has to be notified by another thread on the same lock that it can continue with execution
        - Gives off the 'lock' and has to 'fight' for it under the 'wait-to-whatever' state
        - 

    - yield()
        - ??
        - suggests to JVM that this current thread nolonger needs to be given priority and that the lock can be assigned to a different thread to for execution
        - thread scheduler doesnot however pay attention to it and can or not still excecute the thread to completion
    
    - PRIORITY;
        - Ranges from 1 to 10
        - setPriority(9)/ getPriority()
        - MIN_PRIORITY && MAX_PRIORITY
        - JVM/ thread scheduler has no obligation to follow the priority set, it can or cannot give or deny the priority as needed
    
    - public static void run()
        - To be overriden by extending the Thread class, or assigned runnable instance to ensure execution
        - 

    - Threads scheduler:
        - runs completely differnt every single time assigning randome lock to random threads
        - Is completely shifty from system to system




 */

public class _01_Intro {
}