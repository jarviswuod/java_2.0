public class _54_AnonymousClasses {

    public static void main(String[] args) {

        Runnable rClass = new Runnable() {

            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hi");
                }
            }
        };

        Runnable arClass = new Runnable() {

            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hello");
                }
            }
        };

        Thread t1 = new Thread(rClass);
        Thread t2 = new Thread(arClass);

        t1.start();
        t2.start();
    }
}