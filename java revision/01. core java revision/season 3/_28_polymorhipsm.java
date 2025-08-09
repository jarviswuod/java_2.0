/*
 Existing in many forms

 */

public class _28_polymorhipsm {

    public static void main(String[] args) {
        A a = new A();
        a.methodAll();

        a = new B();
        ((B) a).methodInB();
        a.methodAll();
        a.anotherMethodAll();

        a = new C();
        ((C) a).methodInC();
        a.methodAll();
        a.anotherMethodAll();

        C c = ((C) a);
        c.methodInC();

    }
}

class A {
    public void methodAll() {
        System.out.println("methodAll in A");
    }

    public void anotherMethodAll() {
        System.out.println("anotherMethodAll in A");
    }
}

class B extends A {
    public void methodInB() {
        System.out.println("methodInB in B");
    }

    public void methodAll() {
        System.out.println("methodAll in B");
    }
}

class C extends A {
    public void methodInC() {
        System.out.println("methodInC in C");
    }

    public void methodAll() {
        System.out.println("methodAll in C");
    }
}