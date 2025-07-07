public class _23_SuperAndThisKeywords {
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