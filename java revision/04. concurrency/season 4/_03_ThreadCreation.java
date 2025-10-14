/*

    NOTES:
    - We have 2 ways of creating Threads:
        - Extending the Thread class
        - Implementing the Runnable interface


    - NOTE:
        - The start() method is an asynchronous method that returns immediately an now it's upto JVM to decide what time it will be executed
        - We have 2 ways of creating because we can override Thread class run() while Runnable interface via target which makes run() method run


    - NOT-E-S:
        - We are always advices to go for Runnable interface because we can go for multiple iterfaces besides too Runnable interface compared to only extending the Thread class


    - Extending the Thread class:
        Thread t1 = new CustomThread1();
        Thread t2 = new CustomThread2();

        t1.start();
        t2.start();

        class CustomThread1 extends Thread {

            public void run() {

                for(int i = 0; i < 100; i++) {
                    System.out.println("Hi " + i);
                }
            }
        }

        class CustomThread2 extends Thread {

            public void run() {

                for(int i = 0; i < 100; i++) {
                    System.out.println("Hello " + i);
                }
            }
        }

 */

public class _03_ThreadCreation {
    public static void main(String[] args) {

        Thread t1 = new CustomThread1();
        Thread t2 = new CustomThread2();

        t1.start();
        t2.start();
    }
}

class CustomThread1 extends Thread {

    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("Hi " + i);
        }
    }
}

class CustomThread2 extends Thread {

    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("Hello " + i);
        }
    }
}
