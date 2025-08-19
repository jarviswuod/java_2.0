public class _52_ThreadsExample {
    public static void main(String[] args) {
        Thread t1 = new A();
        Thread t2 = new B();

        t1.start();
        t2.start();
    }
}

class A extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}