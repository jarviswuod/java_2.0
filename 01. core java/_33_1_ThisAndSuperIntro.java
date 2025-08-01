/*

    NOTES:
    - THIS & SUPER KEYWORDS:

    - this:
        - Refers to the current object
        - Used to access current class fields/methods
        - Resolves naming conflicts (e.g., this.name = name)
        - Can be used to call another constructor in the same class (this())

    - super:
        - Refers to the immediate parent class
        - Used to access parent class fields/methods
        - Can be used to call parent class constructor (super())
        - Must be the first statement in a constructor if used

 */

public class _33_1_ThisAndSuperIntro {
    public static void main(String[] args) {

        // B obj = new B();
        B obj = new B(5);
        obj.equals(obj);

    }
}

class A {
    public A() {
        super();
        System.out.println("In A");
    }

    public A(int n) {
        super();
        System.out.println("In A int");
    }
}

class B extends A {
    public B() {
        super();
        System.out.println("In B");
    }

    public B(int n) {
        // super(n);
        this();
        System.out.println("In B int");
    }
}