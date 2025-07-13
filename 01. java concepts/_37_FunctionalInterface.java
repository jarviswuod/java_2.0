/*
 * Functional interface is an interface with only one method
 * Lamda empressions can only be used on funtional interfaces
 */

public class _37_FunctionalInterface {
    public static void main(String[] args) {

        B obj = new B() {
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

class B implements A {

    @Override
    public void show() {
        System.out.println("In show");
    }
}