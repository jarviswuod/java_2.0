/*

    NOTES:
        - Use abstract class
        - Use an interface
        - Use a concrete class

 */

public class _36_InnerClasses {

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