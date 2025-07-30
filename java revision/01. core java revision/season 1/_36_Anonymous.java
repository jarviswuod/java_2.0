/*
    ANONYMOUS CLASS NOTES:

     - A class without a name, declared and instantiated in one line
     - Used to override methods of classes or interfaces on the fly
     - Commonly used with interfaces, abstract classes, or listeners
     - Syntax: new ClassName() { override methods... };
     - Useful for quick, one-time use implementations
 */

public class _36_Anonymous {

    public static void main(String[] args) {
        Animal animal = new Animal() {
            public void name() {
                System.out.println("Jarvis is my name");
            }
        };

        Human human = new Human() {
            public void name() {
                System.out.println("African American/ Black");
            }
        };

        Fish fish = new Fish() {

            @Override
            public void name() {
                System.out.println("Octopus is here with us");
            }

        };

        animal.name();
        human.name();
        fish.name();

    }
}

class Animal {
    public void name() {
        System.out.println("Jarvis");
    }
}

abstract class Human {
    public void name() {
        System.out.println("African American");
    }
}

interface Fish {
    void name();
}