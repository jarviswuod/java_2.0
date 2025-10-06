/*

    NOTES:
    - implements Runnable
        public void run() {...}

        Runnable t1 = () -> {for (int i = 0; i < 100; i++) { System.out.println("Hello: " + i);}};
        Runnable t2 = () -> {for (int i = 0; i < 100; i++) { System.out.println("Hi: " + i);}};

 */

public class _55_LambdaExpression {
    public static void main(String[] args) {

        Runnable t1 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello: " + i);
            }
        };

        Runnable t2 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hi: " + i);
            }
        };

        new Thread(t1).start();
        new Thread(t2).start();
    }
}
