/*
 - The method works perfect and allows for both adding and reading values from the List we provide.(No subclasses allowed)
 - The downside of this is that you are only allowed to provide the EXACT match required (Animal in this case)
    - public static void addAnimal(List<Animal> animalList) {...}

 We add the extends keyword over here to help out with passing not only the Animal class but also Animal subclasses too, say Dog, Cat etc
    - public static void addAnimal(List<? extends Animal> animalList) {...}
    
 Now what this means is that we can now accept not only the Animal class but also it's subclasses (Dog, Cat, Husky) to operate on.
 This makes it possible to retrive things but not able to add them to the List you provide.
 You CANNOT add to the list.
        // animalList.add(new Cat());
        // animalList.add(new Dog());
 This makes it possible to ONLY READ from our Animal List of it's subclass
    addAnimal(dogList);
    addAnimal(animalList);
    addAnimal(catList);

 Other than only reading from the List someone cannot pass a class higher than the one we state, that is;
    - List<? extends Animal> cannot accept any Creature or Object
    - List<? extends Dog> cannot accept any Animal, Creature or Object
    - List<? extends IndianCat> cannot accept any Cat, Animal, Creature or Object

 NOTE:
    We cannot do any data above the super class provided under the extends
        - addAnimal(objectList);
        - addAnimal(creatureList);

        -ERROR:
            - The method addAnimal(List<? extends Animal>) in the type _14_ContravariancePart_2 is not applicable for the arguments (ArrayList<Object>)

 - To go for a more general option, we introduce the 'super' keyword

 */

import java.util.List;
import java.util.ArrayList;

public class _14_ContravariancePart_2 {

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

        addAnimal(dogList);

        System.out.println(" --- --- Cat part --- --- ");

        ArrayList<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new Cat());
        catList.add(new IndianCat());
        addAnimal(catList);

        System.out.println(" --- --- Object part --- --- ");

        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add(new Animal());
        objectList.add(new Animal());
        objectList.add(new Object());
        // addAnimal(objectList);

        System.out.println(" --- --- Creature part --- --- ");

        ArrayList<Creature> creatureList = new ArrayList<>();
        creatureList.add(new Animal());
        creatureList.add(new Animal());
        creatureList.add(new Creature());
        // addAnimal(creatureList);

    }

    public static void addAnimal(List<? extends Animal> animalList) {
        // animalList.add(new Cat()); // Not allowed operation
        // animalList.add(new Dog()); // Not allowed operation

        for (Animal animal : animalList) {
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