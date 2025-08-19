/*
 
    NOTES:
    - Wrapping the child class to be able to access the child methods
    - ((Child) obj).inA()

 */

public class _28_Polymorphism {
    public static void main(String[] args) {

        A objA = new A();
        objA = new B();
        objA.inA();

        ((B) objA).inB();

        B objB = new B();
        B objB2 = (B) objA;
    }
}

class A {
    void inA() {
        System.out.println("inA  in A");
    }

    void forAll() {
        System.out.println("forAll  in A");
    }
}

class B extends A {
    void inA() {
        System.out.println("inA  in B");
    }

    void inB() {
        System.out.println("inBBBBB  in B");
    }
}

class C extends A {
    void inA() {
        System.out.println("inA  in C");
    }
}