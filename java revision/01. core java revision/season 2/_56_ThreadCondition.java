public class _56_ThreadCondition {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        System.out.println(counter.counts);

        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.doCount();
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.doCount();
            }
        };

        Thread a = new Thread(r1);
        Thread b = new Thread(r2);

        b.start();
        a.start();

        b.join();
        a.join();

        System.out.println(counter.counts);
    }
}

class Counter {
    int counts = 0;

    public synchronized void doCount() {
        counts++;
    }
}