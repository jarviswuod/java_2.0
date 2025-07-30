/*

    OFFHEAD NOTES:

    ABSTRACT CLASS:
     - Can have both abstract and concrete methods
     - Abstract methods must be implemented by the first concrete subclass
     - Abstract methods can only exist in abstract classes
     - Abstract classes can have any access modifier (private, protected, etc.)
     - Cannot be instantiated directly

    INTERFACE vs ABSTRACT CLASS:
     - Interface cannot have constructors; abstract classes can
     - Interface members are public by default; abstract class members can have any modifier
     - A class can implement multiple interfaces; can extend only one abstract class
     - Interfaces focus on capabilities ("what"); abstract classes define partial behavior ("how")
     - Interfaces support default and static methods (Java 8+)

 */

public class _34_AbstractKeyword {

    public static void main(String[] args) {

    }
}

abstract class Animal {
    abstract public void printName();

    public String giveName() {
        System.out.println("Jarvis");
        return "Jarvis";
    }
}

class Dog extends Animal {

    @Override
    public void printName() {
        System.out.println("My nae is Jarvis");
    }
}