/*

    NOTES:
    - OFFHEAD NOTES:
        - Thread safety
        - Deadlock
        - Race condition
        - states:
            - running
            - blocked-waiting-for-join-lock
            - ready-to-run
            - blocked-for-io

        - Methods:
            - wait
            - notify/ notifyAll
            - sleep
            - yield
            - join
            - 
        
        - Thread scheduler
        - Thread priorities
        - synchronized & lock Object
            - block
            - method
            - multisync
            - static
            - this

        - volatile

        - Creating threads:
            - extends Thread class
            - implement Runnable method
            - custom Thread name
                - Thread.currentThread().getName()

    - REVISION NOTES:
        - Multitasking refers to handing multiple operation concurrently within a computer
        - Types:
            - process-based multitasking
            - Thread-based multitasking

        - Difference between process and Thread:
            - Thread share the same memory adress
            - Easy communication between threads because they are sharing the same memory address
            - context switching btwn threads is less expensive compared to process

        - Why; multithreading helping in maximizing the use of CPU cycle without wasting any resources

 */

public class _01_Intro {
}