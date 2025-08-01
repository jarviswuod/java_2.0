/*

    NOTES:
       - Thread: smallest unit of execution
       - Multiple threads can run concurrently
       - Threading handled automatically in most frameworks
       - start() runs thread in parallel, internally calls run()
       - sleep(ms) pauses execution
     

    Creating threads using Thread class:
       - Extend Thread class
       - Override run() method
       - Call start() to begin execution


    Creating threads using Runnable interface:
       - Create class that implements Runnable
       - Override run() method with task logic
       - Pass instance to Thread: new Thread(runnableObj)
       - Call start() on thread to begin execution

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