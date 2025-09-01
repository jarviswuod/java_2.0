/*

    NOTES:
    - Threads:
        - A thread is an independent sequential path of execution within a program
        - Multiple threads can run concurrently within a program
        - At runtime, threads in a program exist in a common memory space and can therefore share both data and code hence are lightweight compared to processes

        - 3 multithreading concepts
            - Creating threads and providing the code that gets executed by a thread
            - Accessing commom data and code through synchronization 
            - Transitioning between thread states


    - The Main Thread:
        - When a standalone application is run, a user thread is automatically created to execute the main() method of the application. This thread is called the main method
        - All other threads, called child threads, are spawned from the main thread
        - The main() method can then finish, but the program will keep running until all user threads have completed
        - The runtime environment distinguishes between user threads and daemon threads
        -  Calling the setDaemon(boolean) method in the Thread class (before it's started) marks the status of the thread as either daemon or user
        - As long as a user thread is alive, the JVM doesnot terminate
        - A daemon thread can be stopped if there are not more user threads running thus terminating the program


    - Thread Creation:
        - A thread in Java is represented by an object of the Thread class
        - Creating threads is achieved in one of two ways:
            1. Implementing the java.lang.Runnable interface
            2. Extending the java.lang.Thread class

 */

public class _02_Threads {
}