/*

    NOTES:
    - Creating Thread
        - Using Thead class
            - class Program extends Thread {...}

            - Custom Thread name
                - new Program("program thread")
                - public Program(String name) {
                    super(name);
                }
                - Thread.currentThread().getName()


        - Using Runnable interface


 */

public class _03_Thread {
    public static void main(String[] args) {

        Program program = new Program("program thread");
        // Program programNoName = new Program();
        // program.setDaemon(true);
        program.start();

        Thread thread2 = new Thread(new Runna(), "runna Thread");
        // Thread thread2 = new Thread(new Runna());
        thread2.start();

        System.out.println("Main is existing");
    }
}

class Program extends Thread {
    public Program(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside Program : " + Thread.currentThread().getName() + " " + i);
        }
    }
}

class Runna implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + ": " + i);
        }
    }
}