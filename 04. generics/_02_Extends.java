/*

    NOTES:
    - Home<T> -> unbounded Type parameter
    - What this means is that you can initialize Home to any kind of class you want; say Dog, Cat, an Integer, a String to our Home class
            Home<Dog> dogHome = new Home(new Dog(), new Dog());
            Home<Cat> catHome = new Home(new Cat(), new Cat());

            Home<String> stringHome = new Home(new String(), new String());


    - Home<T extends Animal> - This is setting an upperBound parameter
    - What this means is typically is, you can instanciate your Home class to any variable really. What you have to ensure is that the variable is either Animal class or Animal subclass; Dog(), Cat(), IndianCat() or Husky()
    - At this point when you try to instanciate Home class with any other bound; say String(),Object(), Integer(), it will cause an exception saying "Bound mismatch"
    - When you try to get something above the Animal say 'Creature' or 'Object', You'll also get the same error "Bound mismatch"
    - Extends is used to specify the upperbound

 */

public class _02_Extends {

    public static void main(String[] args) {

        Home<Dog> dogHome = new Home(new Dog(), new Dog());
        Home<Dog> dog1Home = new Home(new Husky(), new Dog());
        Home<Cat> catHome = new Home(new Cat(), new Cat());

        // Home<Creature> creatureHome = new Home(new Creature(""), new Creature(""));
        // // compile time error

        System.out.println(dogHome);
        System.out.println(dog1Home);
        System.out.println(catHome);

    }
}

class Home<T extends Animal> {
    // class Home<T> {
    private T animal1;
    private T animal2;

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
