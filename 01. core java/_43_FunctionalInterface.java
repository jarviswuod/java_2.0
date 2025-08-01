/*
    NOTES:
       - A functional interface is an interface that contains exactly one abstract method.
       - It can have multiple default or static methods, but only one abstract method.
       - Functional interfaces are used primarily to define the target type for lambda expressions.
     
 */

public class _43_FunctionalInterface {
    public static void main(String[] args) {

        A obj = new A() {
            @Override
            public void show() {
                System.out.println("In show class");
            }
        };

        obj.show();
    }
}

@FunctionalInterface
interface A {
    void show();
}