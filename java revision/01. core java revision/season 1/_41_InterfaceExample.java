/*

    NOTES:
      - This example demonstrates how to use interfaces in Java.
      - The `Computer` interface defines a method `code()`.
      - The `Laptop` and `Desktop` classes implement the `Computer` interface.
      - The `Developer` class has a method `devApp()` that takes a `Computer` object as an argument.
      - This allows the developer to work with any type of computer, promoting flexibility and reusability.

 */

public class _41_InterfaceExample {

    public static void main(String[] args) {
        Machine lap = new Laptop();
        Machine desk = new Computer();

        Developer developer = new Developer("Jarvis");

        developer.codingTest();
        developer.prefertoCode(desk);
        System.out.println();
        developer.prefertoCode(lap);
    }
}

interface Machine {
    void code();
}

class Laptop implements Machine {

    @Override
    public void code() {
        System.out.println("Just Fucking code");
    }
}

class Computer implements Machine {

    @Override
    public void code() {
        System.out.println("Just Fucking code but faster");
    }
}

class Developer {

    public Developer(String name) {
        System.out.println("Welcome to our company " + name);
    }

    public void codingTest() {
        System.out.println("Im here to test your coding and typing skills ");
    }

    public void prefertoCode(Machine machine) {
        machine.code();
    }
}