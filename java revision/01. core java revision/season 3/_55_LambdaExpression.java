public class _55_LambdaExpression {

    public static void main(String[] args) {

        Runnable rClass = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hi");
            }
        };

        Runnable arClass = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello");
            }
        };

        Thread t1 = new Thread(rClass);
        Thread t2 = new Thread(arClass);

        t1.start();
        t2.start();
    }
}
