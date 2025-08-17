/*

    NOTES:
    - A deadlock is situation where a thread is waiting for an object lock that another thread holds, and this second thread is waiting for an object lock that the first thread holds
    - Since each thread is waiting for the other to relinquish a lock, they both remain waiting forever in the Blocked-for-lock acquisition state
    - The threads are said to be deadlocked

 */

public class _08_DeadLocks {
    public static void main(String[] args) {

        System.out.println("Main is starting");

        String lock1 = "jarvis";
        String lock2 = "wuod";

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("Lock acquired");
                }
            }
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("Lock acquired");
                }
            }
        }, "Thread2");

        thread1.start();
        thread2.start();

    }
}