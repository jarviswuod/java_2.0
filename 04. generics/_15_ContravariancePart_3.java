/*
 When we introduce the super keyword/ change the extends keyword to 'super'
    - public static void addAnimal(List<? super Animal> animalList) {
 Observation made is;
    Some method calls don't work any more
        Any subclass below the Animal class
            - addAnimal(dogList);
            - addAnimal(catList);

    Some methods now work pretty good
        Any super class methos above the Animal class
            - addAnimal(animalList);
            - addAnimal(objectList);
            - addAnimal(creatureList);

    We are not able to read from the list anymore
        for (Animal animal : animalList) {
            System.out.println(animal);
        }

 The reading part is fair because how can we READ the animalList as an 'Animal'. Keep in mind the animalList can contain a 'creatureList' or above, you cannot get the Creature object and then set it to animal, NOT POSSIBLE
    - Animal animal = animalList.get(0);
 In layman language;
    - Animal animal = new Creature(); // NOT POSSIBLE

 The same concept applies if we have the List set to 'Creature' class and we try to pass in an 'objectList'
    List<? super Animal> animalList
    addAnimal(objectList); // NOT POSSIBLE
    - Animal animal = animalList.get(0);
 In layman language again;
    - Creature creature = new Object(); // NOT POSSIBLE

 
 To be on the safer side, you need to provide an Object ALWAYS
    - Object animal = animalList.get(0);
    - Object animal = new Object();

         for (Object animal : animalList) {
            System.out.println(animal);
        }
 NOTE:
    - super means, If we ever gonna retrive elements from a list, it's gonna be give back the elements inform of Objects ONLY. This is because, you dont know what list you will always be getting, it might be from the highest end begin the object class it's self based on super being set to the lower bound.
    - In reality we dont always use 'super' for retriving values. We use extends to retrieve. This is because with extends, we can retrieve things as a specific type i.e as a Dog, a Cat or say Animal. In 'super' we do it with Object as we dont know what the type might be.
    - Whenever we have extends we cannot add elements to the list.

 - The super keyword is used for adding elements, the issue we face with 'extends'
 
 */

import java.util.List;
import java.util.ArrayList;

public class _15_ContravariancePart_3 {

    public static void main(String[] args) {

        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(new Dog());
        animalList.add(new Dog());
        animalList.add(new Dog());

        addAnimal(animalList);
        System.out.println(" --- --- Another part --- --- ");

        ArrayList<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());
        dogList.add(new Husky());

        // addAnimal(dogList);

        System.out.println(" --- --- Cat part --- --- ");

        ArrayList<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new Cat());
        catList.add(new IndianCat());
        // addAnimal(catList);

        System.out.println(" --- --- Object part --- --- ");

        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add(new Animal());
        objectList.add(new Animal());
        objectList.add(new Object());
        addAnimal(objectList);

        System.out.println(" --- --- Creature part --- --- ");

        ArrayList<Creature> creatureList = new ArrayList<>();
        creatureList.add(new Animal());
        creatureList.add(new Animal());
        creatureList.add(new Creature());
        addAnimal(creatureList);

    }

    public static void addAnimal(List<? super Animal> animalList) {
        // animalList.add(new Cat()); // Not allowed operation
        // animalList.add(new Dog()); // Not allowed operation

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