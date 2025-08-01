/*

    NOTES:
        USING Thread class:
           - Create class that extends Thread
           - Override run() method with task logic
           - Create a Thread object
           - Call start() to begin execution


        EXAMPLE:
            class MyTask extends Thread {
                public void run() {...}
            }

            MyTask t1 = new MyTask();
            t1.start();

*/

public class _55_ThreadClassExample {
    public static void main(String[] args) {
        A objA = new A();
        B objB = new B();

        objA.start();

        objB.start();
    }
}

class A extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}