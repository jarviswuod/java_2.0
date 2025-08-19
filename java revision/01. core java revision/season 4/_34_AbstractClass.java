/*
 
    NOTES:
    - abstract;
        - use 'abstract' keyword
        - abstract class can have both abstract methods and concrete methods too
        - abstract methods only exist inside abstract class
        - abstract class and methods can have any access modifiers
        - abstract class can have a constructor
        - abstract methods must all be implemented under the first concrete class


    - Interface VS abstract class
        - no constructor, yes constructor
        - public members by default, any access modifier
        - multiple implementations, single extending
        - Abstract Methods only except for default and static

 */

public class _34_AbstractClass {
    public static void main(String[] args) {
        Jarvis.nameJarvis();
        Jarvis another = new Another();
        another.myAge();

        System.out.println(another.myName);

    }
}

interface Jarvis {
    String myName = "Jarvis is my name";

    void naming();

    static void nameJarvis() {
        System.out.println("Jarvis");
    }

    default void myAge() {
        System.out.println("I am 9");
    }
}

class Another implements Jarvis {

    @Override
    public void naming() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'naming'");
    }

}