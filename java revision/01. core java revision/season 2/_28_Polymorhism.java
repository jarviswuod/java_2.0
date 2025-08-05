public class _28_Polymorhism {

    public static void main(String[] args) {
        A a = new A();
        a.show();
        a.showAll();

        B b = new B();
        b.showAll();
        b.showB();

        C c = new C();
        c.showAll();
        c.showC();

        System.out.println();
        System.out.println();
        System.out.println();

        A a_ = new A();
        a_.show();
        a_.showAll();

        a_ = new B();
        a_.show();
        a_.showAll();
        ((B) a_).showB();

        a_ = new C();

        C c_ = ((C) a_);
        c_.showC();
    }
}

class A {
    public void show() {
        System.out.println("Show");
    }

    public void showAll() {
        System.out.println("show All");
    }
}

class B extends A {
    public void show() {
        System.out.println("Show in B");
    }

    public void showB() {
        System.out.println("Show only in B");
    }
}

class C extends A {
    public void show() {
        System.out.println("Show in C");
    }

    public void showC() {
        System.out.println("Show only in C");
    }
}