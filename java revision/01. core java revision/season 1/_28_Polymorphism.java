/*

    NOTES (Java):
    - POLYMORPHISM
          - Means "many forms"
          - Allows one interface to be used for different underlying forms (data types)
          - Achieved via method overriding (runtime) and method overloading (compile time)

 */

public class _28_Polymorphism {

    public static void main(String[] args) {

        // sample 1
        A a = new A();
        a.show();

        B b = new B();
        b.show();
        b.showInB();

        C c = new C();
        c.show();
        c.showInC();

        System.out.println();
        System.out.println();
        System.out.println();

        // sample 2
        A a_ = new A();
        a_.show();

        a_ = new B();
        a_.show();
        // a_.showInB();
        ((B) a_).showInB();

        a_ = new C();
        // A c_ = ((C) a_);
        // c_.showInC();

        C _c_ = ((C) a_);
        _c_.showInC();

    }
}

class A {
    public void show() {
        System.out.println("Show in A");
    }
}

class B extends A {
    public void show() {
        System.out.println("Show in B");
    }

    public void showInB() {
        System.out.println("Show in B ONLY");
    }
}

class C extends A {
    public void show() {
        System.out.println("Show in C");
    }

    public void showInC() {
        System.out.println("Show in C ONLY");
    }
}