/*
    Types of Inner Classes
        1. Non-static Inner Classes (Member Inner Classes)
        2. Static Inner Classes (Static Nested Classes)
        3. Method Local Inner Classes
        4. Anonymous Inner Classes

    Key Points to Remember
        1. Non-static inner classes -> hold a reference to the outer class instance
        2. Static inner classes -> don't hold outer class reference - more memory efficient
        3. Method local classes -> can access local variables only if they're final or effectively final
        4. Anonymous classes -> are great for one-time use implementations
        5. Inner classes can have any access modifier (private, protected, public, default)
        6. You can have multiple inner classes in one outer class

    When to Use Inner Classes
        - Non-static: When the inner class needs access to outer class instance members
        - Static: When you want to group related classes together but don't need outer class access
        - Method local: For temporary, method-specific functionality
        - Anonymous: For quick implementations, especially with functional interfaces
 */

// /////////////////////////////////////////////////////////////////////////////////////////
// EXAMPLE 1
// /////////////////////////////////////////////////////////////////////////////////////////
public class _38_InnerClasses {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

        A.C obj2 = obj.new C(); // Non-static inner class instantiated through outer class instance
        obj2.config();

        A.C obj3 = new A().new C(); // One-liner instantiation of non-static inner class
        obj3.config();

        A.B obj1 = new A.B(); // Static inner class instantiated without outer class
        obj1.config();

        A.B.showStaticInner(); // Call static methods directly
    }
}

class A {
    int age;

    public void show() {
        System.out.println("In show");
    }

    static class B {
        public void config() {
            System.out.println("In config");
        }

        public static void showStaticInner() {
            System.out.println("In showStaticInner");
        }
    }

    class C {
        public void config() {
            System.out.println("In C config");
        }
    }
}

// /////////////////////////////////////////////////////////////////////////////////////////
// 1. Non-Static Inner Classes (Member Inner Classes)
// /////////////////////////////////////////////////////////////////////////////////////////
class _34_1_InnerClasses {
    public static void main(String[] args) {
        // Create outer class instance first
        OuterClass outer = new OuterClass();

        // Method 1: Create inner class through outer class method
        outer.createInner();

        // Method 2: Create inner class directly
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.displayBoth();

        // Method 3: One-liner creation
        OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();
        inner2.innerMethod();
    }
}

class OuterClass {
    private String outerField = "Outer field";
    private static String staticOuterField = "Static outer field";

    public void outerMethod() {
        System.out.println("Outer method called");
    }

    // Non-static inner class
    class InnerClass {
        private String innerField = "Inner field";

        public void innerMethod() {
            // Can access outer class members directly
            System.out.println("Accessing: " + outerField);
            System.out.println("Accessing: " + staticOuterField);
            outerMethod(); // Can call outer methods

            // Can access outer class using OuterClass.this
            System.out.println("Outer reference: " + OuterClass.this.outerField);
        }

        public void displayBoth() {
            System.out.println("Inner: " + innerField);
            System.out.println("Outer: " + outerField);
        }
    }

    public void createInner() {
        InnerClass inner = new InnerClass();
        inner.innerMethod();
    }
}

// /////////////////////////////////////////////////////////////////////////////////////////
// 2. Static Inner Classes (Static Nested Classes)
// /////////////////////////////////////////////////////////////////////////////////////////
class _34_2_InnerClasses {
    public static void main(String[] args) {
        // No need to create outer class instance
        OuterClassStatic.StaticInnerClass staticInner = new OuterClassStatic.StaticInnerClass();
        staticInner.innerMethod();

        // Can call static methods directly
        OuterClassStatic.StaticInnerClass.staticInnerMethod();
    }
}

class OuterClassStatic {
    private String outerField = "Outer field";
    private static String staticOuterField = "Static outer field";

    public void outerMethod() {
        System.out.println("Outer method called");
        System.out.println(outerField);
    }

    public static void staticOuterMethod() {
        System.out.println("Static outer method called");
    }

    // Static inner class
    static class StaticInnerClass {
        private String innerField = "Static inner field";

        public void innerMethod() {
            // Can only access static members of outer class
            System.out.println("Accessing: " + staticOuterField);
            System.out.println(innerField);

            staticOuterMethod();

            // System.out.println(outerField); // ERROR! Cannot access non-static
            // outerMethod(); // ERROR! Cannot access non-static
        }

        public static void staticInnerMethod() {
            System.out.println("Static method in static inner class");
        }
    }
}

// /////////////////////////////////////////////////////////////////////////////////////////
// 3. Method Local Inner Classes
// /////////////////////////////////////////////////////////////////////////////////////////
class _34_3_InnerClasses {
    private String outerField = "Outer field";

    public void outerMethod() {
        String localVariable = "Local variable";
        final String finalLocal = "Final local";
        int number = 10;

        // Method local inner class
        class LocalInnerClass {
            public void localInnerMethod() {
                System.out.println("Accessing outer field: " + outerField);
                System.out.println("Accessing local variable: " + localVariable);
                System.out.println("Accessing final local: " + finalLocal);
                System.out.println("Accessing number: " + number);
            }
        }

        // Create and use the local inner class
        LocalInnerClass localInner = new LocalInnerClass();
        localInner.localInnerMethod();

        // number = 20; // This would cause error in localInnerMethod
    }

    public static void main(String[] args) {
        _34_3_InnerClasses example = new _34_3_InnerClasses();
        example.outerMethod();
    }
}

// /////////////////////////////////////////////////////////////////////////////////////////
// 4. Anonymous Inner Classes
// /////////////////////////////////////////////////////////////////////////////////////////
class _34_4_InnerClasses {
    public static void main(String[] args) {
        // Anonymous class implementing interface
        Greeting greeting = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Hello, " + name + "!");
            }
        };
        greeting.greet("Alice");

        // Anonymous class extending abstract class
        Animal dog = new Animal() {
            @Override
            void makeSound() {
                System.out.println("Woof! Woof!");
            }
        };
        dog.makeSound();
        dog.sleep();

        // Anonymous class with additional methods
        Greeting fancyGreeting = new Greeting() {
            private String prefix = "Welcome";

            @Override
            public void greet(String name) {
                System.out.println(prefix + ", " + name + "!");
                farewell();
            }

            private void farewell() {
                System.out.println("Have a great day!");
            }
        };
        fancyGreeting.greet("Bob");
    }
}

interface Greeting {
    void greet(String name);
}

abstract class Animal {
    abstract void makeSound();

    public void sleep() {
        System.out.println("Animal is sleeping");
    }
}
