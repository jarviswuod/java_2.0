public class _53_ThreadInterface {
    public static void main(String[] args) {

        Runnable r1 = new A();
        Runnable r2 = new B();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
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