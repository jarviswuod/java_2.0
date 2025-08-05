public class _54_AnonymousClasses {

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hello");
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hi");
                }
            }
        };

        Thread a = new Thread(r1);
        Thread b = new Thread(r2);

        b.start();
        a.start();
    }
}