public class _53_ThreadsInterface {

    public static void main(String[] args) {

        Runnable r1 = new A();
        Runnable r2 = new B();

        Thread a = new Thread(r1);
        Thread b = new Thread(r2);

        b.start();
        a.start();
    }
}

class A implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}

class B implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}