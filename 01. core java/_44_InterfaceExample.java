/*

    NOTES:
      - This example demonstrates how to use interfaces in Java.
      - The `Computer` interface defines a method `code()`.
      - The `Laptop` and `Desktop` classes implement the `Computer` interface.
      - The `Developer` class has a method `devApp()` that takes a `Computer` object as an argument.
      - This allows the developer to work with any type of computer, promoting flexibility and reusability.

 */

public class _44_InterfaceExample {
    public static void main(String[] args) {

        Developer dev = new Developer();

        Computer lap = new Laptop();
        Computer desk = new Desktop();

        dev.devApp(lap);
        dev.devApp(desk);
    }
}

class Developer {
    public void devApp(Computer lap) {
        lap.code();
    }
}

interface Computer {
    void code();
}

class Laptop implements Computer {

    public void code() {
        System.out.println("Code, complie, run : Fast");
    }
}

class Desktop implements Computer {

    public void code() {
        System.out.println("Code, complie, run : Faster");
    }
}
