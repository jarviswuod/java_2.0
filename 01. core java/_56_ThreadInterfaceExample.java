/*

    NOTES:
        USING Runnable:
          - Create class that implements Runnable
          - Override run() method with task logic
          - Pass instance to Thread: new Thread(runnableObj)
          - Call start() on thread to begin execution

        EXAMPLE:
            class MyTask implements Runnable {
                public void run() {...}
            }

            Runnable r1 = new MyTask();
            Thread t1 = new Thread(r1);
            t1.start();

*/

public class _56_ThreadInterfaceExample {
    public static void main(String[] args) {
        Runnable objA = new A();
        Runnable objB = new B();

        Thread t1 = new Thread(objA);
        Thread t2 = new Thread(objB);

        t1.start();
        t2.start();
    }
}

class A implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}

class B implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}