/*

    NOTES:
    - <T> -> unbounded Type parameter
        - ANY kind of object is allowed. Example;
             - Home<Dog> dogHome = new Home(new Dog(), new Dog());
             - Home<String> stringHome = new Home(new String(), new String());


    - <T extends Animal> -> upper bounded Type parameter
        - ONLY Animal or Animal subclass objects allowed. Example;
             - Home<Dog> dog1Home = new Home(new Husky(), new Dog());  // Works perfect


        - "Bound mismatch" exception for non Animal objects. Example;
             - Home<Integer> integerHome = new Home(new Integer(10), new Integer(10)); // Bound mismatch


        - "Bound mismatch" exception for above Animal object
             - Home<Creature> creatureHome = new Home(new Creature(), new Creature()); // Bound mismatch

 */

public class _02_Extends {

    public static void main(String[] args) {

        Home<Animal> animalObjects = new Home<>(new Cat(), new Dog());
        System.out.println(animalObjects);

        // Home<Creature> creatureObjects = new Home<>(new Cat(), new Dog());
        // System.out.println(creatureObjects);

        // Home<String> stringObjects = new Home<>(new String(), new String());
        // System.out.println(stringObjects);

    }

}

class Home<T extends Animal> {
    // class Home<T> {
    T animal1;
    T animal2;

    public Home(T animal1, T animal2) {
        this.animal1 = animal1;
        this.animal2 = animal2;
    }

    public T getAnimal1() {
        return animal1;
    }

    public T getAnimal2() {
        return animal2;
    }

    @Override
    public String toString() {
        return "Home [animal1=" + animal1 + ", animal2=" + animal2 + "]";
    }

}

class Creature {
}

class Animal extends Creature {
}

class Dog extends Animal {
}

class Husky extends Dog {
}

class Cat extends Animal {
}

class IndianCat extends Cat {
}