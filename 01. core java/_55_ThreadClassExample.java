/*
 * class extends Thread
 * run() defined
 * start() on class instance
 * 
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