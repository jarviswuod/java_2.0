/*
 * 
 * class implements Runnable
 * run() defined
 * Runnable objA = new A(); -->|<-- Runnable reference type on class object type
 * Thread t1 = new Thread(objA); -->|<-- Creating new Thread object with runnable object
 * start() on created thread instance
 *
 * 
 * NOTE:
 * -> Runnable objA = new A();
 * -> Thread t1 = new Thread(objA);
 * -> t1.start();
 *  
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