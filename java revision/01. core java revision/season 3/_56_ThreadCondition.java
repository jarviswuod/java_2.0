public class _56_ThreadCondition {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        System.out.println("Starters : " + counter.counts);

        Runnable rClass = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.counting();
            }
        };

        Runnable arClass = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.counting();
            }
        };

        Thread t1 = new Thread(rClass);
        Thread t2 = new Thread(arClass);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Enders : " + counter.counts);

    }
}

class Counter {
    public int counts = 0;

    public synchronized void counting() {
        counts++;
    }
}