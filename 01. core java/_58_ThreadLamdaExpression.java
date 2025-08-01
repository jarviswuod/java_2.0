/*
    
    NOTES:
       - Lambda is a shorter way to write anonymous classes (Java 8+)
       - Runnable is a functional interface (1 abstract method) so it supports lambdas
       - Removes boilerplate and improves readability

    EXAMPLE:
        Runnable r = () -> {...};

*/

public class _58_ThreadLamdaExpression {
    public static void main(String[] args) {

        Runnable objA = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hi");
            }
        };

        Runnable objB = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello");
            }
        };

        Thread t1 = new Thread(objA);
        Thread t2 = new Thread(objB);

        t1.start();
        t2.start();
    }
}