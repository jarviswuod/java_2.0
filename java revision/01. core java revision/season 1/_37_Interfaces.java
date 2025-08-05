/*

    OFFHEAD NOTES:

     - By default, interface methods are public and abstract
     - Every variable in interfaces are final & static
     - By default every interface method is a public and static
     - Use `default` or `static` to define concrete methods in interfaces (Java 8+)
     - Concrete classes use `implements` to implement interfaces
     - A class can implement multiple interfaces (multiple inheritance support)
     
     TYPES:
       - Functional Interface (@FunctionalInterface): exactly one abstract method
       - Normal Interface: one or more abstract methods
       - Marker Interface (empty): no methods; used for tagging (e.g., Serializable)

     - Interfaces support abstraction, loose coupling, and contract enforcement

 */

public class _37_Interfaces {

    public static void main(String[] args) {
        Fish fish = new RandomFish();

        fish.name();
        fish.nameAgain();
        Fish.nameInstatic();
    }
}

// @FunctionalInterface
interface Fish {
    void name();

    default void nameAgain() {
        System.out.println("Default interface method is here");
    }

    static void nameInstatic() {
        System.out.println("Static method is here too to stay");
    }

}

class RandomFish implements Fish {

    @Override
    public void name() {
        System.out.println("Random name from nowhere");
    }

}