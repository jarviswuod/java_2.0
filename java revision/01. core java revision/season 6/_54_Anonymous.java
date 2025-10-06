/*

    NOTES:
    - implements Runnable
        public void run() {...}

        Thread t1 = () -> for(int i = 0; i<100;i++) {System.out.println("Hello :" + i)};
        t1.start();

        Thread t2 = () -> for(int i = 0; i<100;i++) {System.out.println("Hi :" + i)};
        t2.start();


 */

public class _54_Anonymous {
    public static void main(String[] args) {

        Thread t1 = new Nothing() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hello: " + i);
                }
            }
        };

        Thread t2 = new Nothing() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hi: " + i);
                }
            }
        };
        t1.start();
        t2.start();
    }
}

class Nothing extends Thread {
    public void run() {
    }
}