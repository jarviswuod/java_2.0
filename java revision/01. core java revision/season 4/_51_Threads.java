/*

    NOTES:
    Thread  t1 = new ClassName();
    t1.start();
    class ClassName extends Thread {
        public void run() {
            for(int i = 0; i<100; i++) {
                System.out.println("Jarvis");
            }
        }
    }

 */

public class _51_Threads {
    public static void main(String[] args) {
        Thread t1 = new ClassName();
        t1.start();
    }
}

class ClassName extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Jarvis");
        }
    }
}