/*

    OFFHEAD NOTES:
       - extend Threads
       - run()
       - Thread counter = new Counter(); Thread object creation
       - counter.start();

 */

public class _51_Threads {

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.start();
    }
}

class Counter extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello Im here");
        }
    }
}