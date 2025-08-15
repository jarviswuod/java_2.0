/*

    NOTES:
    - Invariant vs Covariant vs Contravariant
        - Invariant -> both read and write
        - Covariant -> only read
        - Contravariant -> only write

    - Invariant:
        - By default generics is Invariant, i.e allowing both read and write methods:
            public static void displayAnimal(List<Dog> doglist) {
                for (Dog animalDog : doglist) {
                    System.out.println(animalDog); // ONLY READ
                }

                doglist.add(new Dog());  // WRITE
                doglist.add(new Husky()); // WRITE
            }

    - Covariant:
        - We make generics in java Covariant by introducing the 'extends' keyword
            public static void displayAnimal(List<? extends Dog> doglist) {
                for (Dog animalDog : doglist) {
                    System.out.println(animalDog); // ONLY READ
                }
            }

    - Contravariant:
        - We make generics in java Contravariant by introducing the 'super' keyword
            public static void displayAnimal(List<? super Dog> doglist) {
                doglist.add(new Dog());  // WRITE ONLY
                doglist.add(new Husky()); // WRITE ONLY
            }

    SUMMARY:
        - Generics in java are invariant
        - We make Generics covariant by introducting;
               - The bounded Type parameter(generic signature) - <T extends Number>
               - The upper bounded wildcard - List<? extends Number>


    WILDCARD:
        - <? super Type> (lower-bounded wildcard):
            - Accepts `Type` or its supertypes.
            - Opposite of covariance, which accepts `Type` or its subtypes.

        - <? extends Type> (upper-bounded wildcard):
            - Accepts `Type` or its subtypes.
            - Opposite of contravariance, which accepts `Type` or its supertypes.

 */

import java.util.ArrayList;
import java.util.List;

public class _17_AfterNotes {

    public static void main(String[] args) {

        // ArrayList<Object> dogList = new ArrayList<>(); works fine too
        ArrayList<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());
        dogList.add(new Husky()); // possible to add Husky because it's a subclass of Dog (Type safe)

        addAnimal_Contravariance(dogList); // No ERROR for Husky class (Type safe)

        System.out.println(" --- --- Object List --- --- ");

        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
        objectList.add(new Object());
        objectList.add(new Husky());
        objectList.add(new Object()); // no ERROR for Object class
        objectList.add(new String()); // no ERROR for String class --> BUT NOT ALLOWED (Type safe)
        objectList.add(new Integer(10)); // no ERROR for Integer class --> BUT NOT ALLOWED (Type safe)

        addAnimal_Contravariance(objectList); // No ERRORS AT ALL
        // (Type safe) it will give object anyways at Object object: animalList level

    }

    public static void displayAnimal_Invariance(List<Dog> doglist) {
        for (Dog animalDog : doglist) {
            System.out.println(animalDog);
        }

        doglist.add(new Dog()); // WRITE ONLY
        doglist.add(new Husky()); // WRITE ONLY
    }

    public static void displayAnimal_Covariance(List<? extends Dog> doglist) {
        for (Dog animalDog : doglist) {
            System.out.println(animalDog); // ONLY READ
        }
    }

    public static void addAnimal_Contravariance(List<? super Dog> doglist) {
        doglist.add(new Dog()); // WRITE ONLY
        doglist.add(new Husky()); // WRITE ONLY
    }

}

class Creature {
}

class Animal extends Creature {
}

class Cat extends Animal {
}

class Dog extends Animal {
}

class Husky extends Dog {
}

class IndianCat extends Cat {
}