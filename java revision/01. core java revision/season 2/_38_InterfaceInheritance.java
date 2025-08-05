/*

    NOTES:
        - interface - interface -> extends
        - class - class -> extends
        - interface - class -> implements

        - Multiple implementations is possible under interfaces

 */

public class _38_InterfaceInheritance {

    public static void main(String[] args) {
        Person person = new Person();

        person.randomAgeMethod();
        person.randomNameMethod();
        person.secondNameMethod();
    }
}

interface Name {
    default void sayName() {
        System.out.println("My name is Jarvis");
    }

    void randomNameMethod();
}

interface SecondName extends Name {
    void secondNameMethod();
}

interface Age {
    default void sayaAge() {
        System.out.println("I am 5 years old");
    }

    void randomAgeMethod();
}

class Person implements SecondName, Age {

    @Override
    public void randomAgeMethod() {
        System.out.println("randomAgeMethod : Name and age");
    }

    @Override
    public void randomNameMethod() {
        System.out.println("randomNameMethod : Name and age");
    }

    @Override
    public void secondNameMethod() {
        System.out.println("secondNameMethod : Name and age");
    }
}