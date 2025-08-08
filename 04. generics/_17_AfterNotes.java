/*
 invariant -> both read and write
 covaraint -> only read
 contravariant -> only write

 invariant:
    - By default generics is invariant, i.e allowing both read and write methods:
        public static void displayAnimal(List<Dog> doglist) {
            for (Dog animalDog : doglist) {
                System.out.println(animalDog); // ONLY READ
            }

            doglist.add(new Dog());  // WRITE
            doglist.add(new Husky()); // WRITE
        }

 covariant:
    - We make generics in java covariant by introducing the 'extends' keyword
        public static void displayAnimal(List<? etends Dog> doglist) {
            for (Dog animalDog : doglist) {
                System.out.println(animalDog); // ONLY READ
            }
        }
 contravarint:
    - We make generics in java covariant by introducing the 'extends' keyword
        public static void displayAnimal(List<? super Dog> doglist) {
            doglist.add(new Dog());  // WRITE ONLY
            doglist.add(new Husky()); // WRITE ONLY
        }

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