public class _29_Polymophism {
    public static void main(String[] args) {
        A objA = new A();
        objA.show();

        B objB = new B();
        objB.show();

        C objC = new C();
        objC.show();

        System.out.println();

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
        System.out.println(obj1);

        System.out.println();
        // obj1.justInC(); // This will cause a compile-time error
        ((C) obj1).justInC();

        System.out.println();

        C cObj = ((C) obj1);
        cObj.justInC();
        System.out.println(cObj);

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
