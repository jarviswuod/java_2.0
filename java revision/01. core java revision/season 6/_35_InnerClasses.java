/*

    NOTES:
    - Static
        - A.B ab = new A.B();
        - new A.B().innerMethod();


    - Non static
        - A.C ac = new A().new C();
        - ac.innerMethod1();


    Method Local Inner Classes
    public static void main(String[] args) {
        _34_3_InnerClasses example = new _34_3_InnerClasses();
        example.outerMethod();
    }


    Anonymous Inner Classes
        - Anonymous class implementing interface
        - Anonymous class extending abstract class

 */

public class _35_InnerClasses {
    public static void main(String[] args) {

        A.B ab = new A.B();
        new A.B().innerMethod();
        System.out.println(ab);

        A.C ac = new A().new C();
        ac.innerMethod1();
    }
}

class A {

    public static class B {

        public void innerMethod() {
            System.out.println("Another Method is here for testing");
        }

    }

    public class C {

        public void innerMethod1() {
            System.out.println("In a make thinggy");
        }
    }
}
