/*

    NOTES:
    - Creating Thread
        - Using Thead class
            - class Program extends Thread {...}

            - Custom Thread name
                - new Program("program thread")
                - public Program(String name) {
                    super(name);
                }
                - Thread.currentThread().getName()


        - Using Runnable interface

    - Whatever code you want executed in a Thead, you write it under the run() method you override when extending the Thread class.
    - start() methods does not start immediately, it's an asynhronous method and returns immediately. It's now upto JVM to start the Thread execution when it wants to
    - Parent child relationship between 2 threads, main begin the parent of other threads
    - No order for execution of Threads
    - If JVM finds no user threads running, it might allow the Deamon threads to run or not. However the program doesnot terminate then there is even a single user thread running


    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    Reason behind why; It's possible to create a Thread in 2 ways;
        1. Pass a Runnable instance which will set the target to our instance and then our instance method will be executed
        2. Extend the Thread class and override the run() method itself
    - Which and Why method should be used to create a Thread;
        - Extending the Thread class limits possibility of extending other classes that you might need
        - One can implement multiple interfaces other than the Runnable as java supports multiple interfaces implementations

 */

public class _03_Thread {
    public static void main(String[] args) {

        Program program = new Program("program thread");
        // Program programNoName = new Program();
        // program.setDaemon(true);
        program.start();

        Thread thread2 = new Thread(new Runna(), "runna Thread");
        // Thread thread2 = new Thread(new Runna());
        thread2.start();

        System.out.println("Main is existing");
    }
}

class Program extends Thread {
    public Program(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside Program : " + Thread.currentThread().getName() + " " + i);
        }
    }
}

class Runna implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + ": " + i);
        }
    }
}