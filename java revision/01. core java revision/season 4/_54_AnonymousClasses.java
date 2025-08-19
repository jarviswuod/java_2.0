public class _54_AnonymousClasses {
    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hi");
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hello");
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
