/*
 - The super keyword is used for adding elements, the issue we face with 'extends'
 Let's say you are writing the method
    - public static void addAnimal(List<? super Animal> animalList) {...}
 What you are really saying over here is that, the List passed here will be either a animalList, or creatureList or objectList, those are the 3 possible probability of objects we will be accpeting in the runtime.
 Don't you think that logically, it's actually safe to add a list of any subclass of Animal inside the method, say Cat or Dog
     - animalList.add(new Cat());
     - animalList.add(new Dog());
    
 This is because, we know whatever will be coming to this List will be something probably larger, or bigger that what we pass in , in this case Animal, Creature, or Object. All this will be able to hold our subclasses we have here. Example;
    public void addAnimal(List<? super Animal> animalList) {
        animalList.add(new Animal());
        animalList.add(new Cat());
        animalList.add(new Dog());
    }

 This is all the same as;
    List<? super Animal> animalList =  new ArrayList<Animal>();
    List<? super Animal> animalList =  new ArrayList<Creature>();
    List<? super Animal> animalList =  new ArrayList<Object>();
 All the arrayLists will and can contain a new Cat, Dog, IndianCat or Husky

 */

import java.util.List;
import java.util.ArrayList;

public class _16_ContravariancePart_4 {

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
        animalList.add(new Cat());
        animalList.add(new Dog());
    }

    public static void addAnimal1(List<? super Animal> animalList) {
        animalList.add(new Animal());
        animalList.add(new Cat());
        animalList.add(new Dog());
        animalList.add(new Husky());
        animalList.add(new IndianCat());

    }

    public static void addAnimal2(List<? super Cat> animalList) {
        animalList.add(new Cat());
        animalList.add(new IndianCat());
        // animalList.add(new Animal()); // Type mistmatch
        // animalList.add(new Dog()); // Type mistmatch
        // animalList.add(new Husky()); // Type mistmatch

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