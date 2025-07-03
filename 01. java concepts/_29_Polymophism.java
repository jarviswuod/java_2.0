public class _29_Polymophism {
    public static void main(String[] args) {
        // A obj = new A();
        // obj.show();

        // obj = new B();
        // obj.show();

        // obj = new C();
        // obj.show();

        A obj1 = new A();
        obj1.show();
        obj1.justInA();
        System.out.println(obj1);

        System.out.println();

        obj1 = new B();
        obj1.show();
        obj1.justInA();
        ((B) obj1).justInB();
        System.out.println(obj1);

        System.out.println();

        obj1 = new C();
        obj1.show();
        obj1.justInA();
        ((C) obj1).justInC();
        System.out.println(obj1);

    }
}

class A {
    public void show() {
        System.out.println("In A show");
    }

    public void justInA() {
        System.out.println("Just in A");
    }
}

class B extends A {
    public void show() {
        System.out.println("In B show");
    }

    public void justInB() {
        System.out.println("Just in B");
    }
}

class C extends A {
    public void show() {
        System.out.println("In C show");
    }

    public void justInC() {
        System.out.println("Just in C");
    }
}
