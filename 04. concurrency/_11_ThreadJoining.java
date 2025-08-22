/*

    NOTES:
    - Thread Joining:
        - Thread once created and is in the 'running' state, it always runs asynchronously(in parallel)  with other threads(example main thread.)
        -  If you want the thread to stop being executed asynchronously and want one particular thread to complete before you handle the other thread.
        - This is where thread.join() method comes into play, what this method does is to pause other threads until it's execution is done before it can resume other thread execution.
        -  Thread is in a 'ready-to-run" state, once it's given priority to execute and you call the join() method, you are simply pausing the asynchronous nature of thread execution and to a 'Blocked-for-join-completion' state.
        - Whatever is returned can be one of the 3;
            - Join compeleted: once the thread execution is complete
            - Time elapsed: you can set timeout when calling the join method
            - Thread Interrupted, applys the same way as the wait() or sleep() methods in threads



    - Thread priorities:
        - Threads are assigned priorities that the thread scheduler can use to determine how the threads will be scheduled
        - The thread scheduler can use thread priorities to determine which thread gets to run
        - The Priorities are integer values from 1(lowest priority) to 10(highest priority) with default being 5;
            - Thread.MIN_PRIORITY
            - Thread.MAX_PRIORITY
            - Thread.NORM_PRIORITY

        - You can use the methods below to monitor and set priority;
            - thread.setPriority(5);
            - thread.getPriority();

        -  NOTE:
            - The setPriority() method is an advisory method, meaning that it provides a hint from the program to the JVM, which the JVM is in no way obliged to honor
        

    - Thread scheduler:
        - Schedulers in JVM implementations usually employ one of the two following strategies;
            - Preemptive scheduling; setPriority(10)
            - Time-sliced or round-robin scheduling; yield()

 */

public class _11_ThreadJoining {
}