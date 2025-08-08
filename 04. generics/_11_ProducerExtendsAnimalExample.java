import java.util.List;
import java.util.ArrayList;

public class _11_ProducerExtendsAnimalExample {
    public static void main(String[] args) {

        ArrayList<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new Cat());
        catList.add(new Cat());

        displayAnimal(catList);

        ArrayList<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());
        dogList.add(new Dog());

        displayAnimal(dogList);

        ArrayList<IndianCat> indianCatList = new ArrayList<>();
        indianCatList.add(new IndianCat());
        indianCatList.add(new IndianCat());
        indianCatList.add(new IndianCat());

        displayAnimal(indianCatList);

        ArrayList<Husky> huskyList = new ArrayList<>();
        huskyList.add(new Husky());
        huskyList.add(new Husky());
        huskyList.add(new Husky());

        displayAnimal(huskyList);

        ArrayList<Creature> creatureList = new ArrayList<>();
        creatureList.add(new Creature());
        creatureList.add(new Creature());
        creatureList.add(new Creature());

        // displayAnimal(creatureList);

        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
        objectList.add(new Object());
        objectList.add(new Object());

        // displayAnimal(objectList);

        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());
        animalList.add(new Animal());
        animalList.add(new Animal());
        // animalList.add(new String());

        displayAnimal(animalList);

    }

    // List<Animal>, List<Cat>, List<Dog>, List<IndianCat>, List<Husky>
    public static void displayAnimal(List<? extends Animal> animalList) {
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
        System.out.println();
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
