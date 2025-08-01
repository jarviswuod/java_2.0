/*

    NOTES:
       - A class without a name, declared and instantiated in one line
       - Used to override methods of classes or interfaces on the fly
       - Commonly used with interfaces, abstract classes, or listeners
       - Syntax: new ClassName() { override methods... };
       - Useful for quick, one-time use implementations

 */

public class _39_AnonymousClasses {
    public static void main(String[] args) {
        A obj1 = new A() {
            public void show() {
                System.out.println("Show in new A");
            }

            public void config() {
                System.out.println("Config in new A");
            }
        };

        obj1.config();
        obj1.show();

        System.out.println();

        B obj2 = new B() {
            public void show() {
                System.out.println("Show in new B");
            }

            public void config() {
                System.out.println("Config in new B");
            }
        };

        obj2.config();
        obj2.show();
    }
}

// 1. On Abstract classes

abstract class A {
    public abstract void show();

    public abstract void config();
}

// 2. On Concrete classes
class B {
    public void show() {
        System.out.println("Show in B");
    }

    public void config() {
        System.out.println("Config in B");
    }
}
