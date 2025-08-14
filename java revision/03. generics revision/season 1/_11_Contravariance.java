/*

    NOTES:
    - When we introduce the 'super' keyword
        - public static void addAnimal(List<? super Animal> animalList) {...}
    - Observations made are;
        - Some method calls don't work any more (Any subclass to Animal class)
            - addAnimal(dogList);
            - addAnimal(catList);

        - Some methods now work pretty good (Any super class to Animal class)
            - addAnimal(animalList);
            - addAnimal(objectList);
            - addAnimal(creatureList);

        - We are not able to READ from the list anymore
            for (Animal animal : animalList) {
                System.out.println(animal);
            }


    - The reading part is fair because how can we READ the animalList as an 'Animal'. Keep in mind the animalList can contain a 'creatureList' or above, you cannot get the Creature object and then cast it to Animal
        - Animal animal = animalList.get(0);

        - In layman language;
            - Animal animal = new Creature(); // NOT POSSIBLE

    - The same concept applies if the List is set to 'Creature' class and we try to pass in an 'objectList'
        - List<? super Animal> animalList
        - addAnimal(objectList);    // Type mismatch:
        
        - Animal animal = animalList.get(0);
        - In layman language;
            - Creature creature = new Object(); // NOT POSSIBLE

 
    - To be on the safer side, you need to provide an Object ALWAYS
        - Object animal = animalList.get(0);
        - Object animal = new Object();

            for (Object animal : animalList) {
                System.out.println(animal);
            }


    SUMMARY:
        - 'super' means, If we ever gonna retrieve elements from a list, it's gonna be given back to the elements inform of Objects ONLY. This is because, complier doesn't know what list you will always be getting, it might be from the highest end, the Object class it's self based on super being set to the lower bound
        - In reality we don't always use 'super' for retrieving values. We use 'extends' keyword instead. This is because with 'extends', can retrieve things as a specific type i.e as a Dog, a Cat or say Animal. In 'super' we do it with Object as we don't know what the type might be

 */

import java.util.List;
import java.util.ArrayList;

public class _11_Contravariance {
    public static void main(String[] args) {

        ArrayList<Animal> animalList = new ArrayList<>();
        addAnimal(animalList);

        ArrayList<Dog> dogList = new ArrayList<>();
        // addAnimal(dogList);

        ArrayList<Cat> catList = new ArrayList<>();
        // addAnimal(catList);

        ArrayList<Object> objectList = new ArrayList<>();
        addAnimal(objectList);

        ArrayList<Creature> creatureList = new ArrayList<>();
        addAnimal(creatureList);
    }

    public static void addAnimal(List<? super Animal> animalList) {

        for (Object animal : animalList) {
            System.out.println(animal);
        }
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