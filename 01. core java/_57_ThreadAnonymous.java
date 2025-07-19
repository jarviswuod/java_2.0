/* 
 
    Instansiating our Runnable interface with help of anonymous classes
 
 */

public class _57_ThreadAnonymous {
    public static void main(String[] args) {
        Runnable objA = new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hi");
                }
            }
        };

        Runnable objB = new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hello");
                }
            }
        };

        Thread t1 = new Thread(objA);
        Thread t2 = new Thread(objB);

        t1.start();
        t2.start();
    }
}