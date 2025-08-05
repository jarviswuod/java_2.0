public class _52_ThreadsExample {

    public static void main(String[] args) {

        Thread a = new A();
        Thread b = new B();

        b.start();
        a.start();
    }
}

class A extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}