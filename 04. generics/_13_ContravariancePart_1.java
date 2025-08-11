/*

    NOTES:
    - List<Animal> means our List variable has to be exactly of type Animal
         -  public static void addAnimal(List<Animal> animalList) {...}

    - This is a good method as you can;
         - READ from the List
             1.) Animal animal1 =  animalList.get(0);
             
             2.) for (Animal animal : animalList) {
                    System.out.println(animal);
                 }

         - WRITE to the List
             - You can also add a new Animal to the List. This can be of any subtype of animal;
                 - animalList.add(new Animal()); // super class
                 - animalList.add(new Cat()); // sub class
                 - animalList.add(new Dog()); // sub class

    - The upside of invariance is that you can add and retrieve also from the same List.
    - The downside however is you can NOT pass any other List type other than the required one, Example passing a List of Dog causes an Type mismatch Exception as """
            The method addAnimal(List<Animal>) is not applicable for the arguments (ArrayList<Dog>);
            """

            ArrayList<Dog> dogList = new ArrayList<>();
                dogList.add(new Dog());
                dogList.add(new Husky());

            addAnimal(dogList); // DOES NOT WORK
    

    - We can bypass this issue by introducing the 'extends' keyword

 */

import java.util.List;
import java.util.ArrayList;

public class _13_ContravariancePart_1 {

    public static void main(String[] args) {

        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(new Dog());
        animalList.add(new Dog());

        animalList.add(new Cat());
        animalList.add(new Cat());

        animalList.add(new Animal());
        animalList.add(new Animal());

        addAnimal(animalList);
        System.out.println(" --- --- Another part --- --- ");

        ArrayList<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());
        dogList.add(new Husky());

        // addAnimal(dogList);

    }

    public static void addAnimal(List<Animal> animalList) {
        animalList.add(new Cat());
        animalList.add(new Dog());

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