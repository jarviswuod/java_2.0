/*
    OFFHEAD NOTES:
    - Overloading:
        - Same method name
        - Different parameter types
        - Different number of parameters
        - Under the same class

 */

public class _15_MethodOverloading {

    public static void main(String[] args) {

        Calc calc1 = new Calc();
        calc1.add();
        calc1.add(4);
        calc1.add(4, 5);

    }
}

class Calc {

    void add() {
        System.out.println(1 + 3);
    }

    void add(int a) {
        System.out.println(4 + a);
    }

    void add(int a, int b) {
        System.out.println(4 + a + b);
    }

}
