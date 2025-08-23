/*

    NOTES:
    - 2 ways of creating threads
        - Thread class
        - Runnable interface; -> Lambda expression

    - Custom Thread name:
        - Only works in Extending thread class
        - Inlucde as the second param on thread definition for Runnable

    - 3 multithreading concepts
        - Creating threads and code base to be run
        - Accessing shared data
        - Different states of threads

    - User thread vs daemon thread

    - Runnable interface is used over Thread class because it can use to implement multiple other interfaces
    - run() 2 ways coz;
        - you can extend and overide the run method
        - you can implement the run method by passing runnable instance to run it

 */

public class _02_Threads {
    public static void main(String[] args) {

        // Thread t1 = new ThreadClass1("thread1");
        // Thread t2 = new ThreadClass2("thread2");

        // t1.start();
        // t2.start();

        // Thread t3 = new Thread(new ThreadRunnable1(), "runnable1");
        // Thread t4 = new Thread(new ThreadRunnable2(), "runnable2");

        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello");
            }
        }, "runnable lambda 1");

        Thread t4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 100; i++) {
                System.out.println("Hi");
            }
        }, "runnable lambda 2");

        t3.start();
        t4.start();
    }
}

class ThreadRunnable1 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}

class ThreadRunnable2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}

class ThreadClass1 extends Thread {
    public ThreadClass1(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}

class ThreadClass2 extends Thread {
    public ThreadClass2(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}