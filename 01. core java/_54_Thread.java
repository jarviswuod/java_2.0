/*
    
    NOTE:
     - Thread is the smallest unit in which we can divide a task into 
     - We can tun multiple threads at the same time
     - In most frameworks thread is mainly handled automatically
    
    
    HOW TO ACHIEVE THREADING USING Thread class:
     - class extends Thread
     - run() defined
     - Thread.sleep(10);
    
 */

public class _54_Thread {
    public static void main(String[] args) {
        A objA = new A();
        objA.start();
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