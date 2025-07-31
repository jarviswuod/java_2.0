public class _56_ThreadCondition {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        System.out.println(counter.counts);

        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.addCount();
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.addCount();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.counts);

    }
}

class Counter {

    int counts = 0;

    public synchronized void addCount() {
        counts++;
    }
}