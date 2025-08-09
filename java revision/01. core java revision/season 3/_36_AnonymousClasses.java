/*

    NOTES:
        To manage inner classes we can use
            - concrete classes
            - interface
            - abstract classes

 */

public class _36_AnonymousClasses {

    public static void main(String[] args) {

        Animal animal = new Animal() {

            @Override
            public void animalName() {
                System.out.println("Animal name is defined here");
            }
        };
        animal.animalName();
    }
}

abstract class Animal {
    public abstract void animalName();
}