/*

    NOTES:
    - <T> -> unbounded Type parameter
        - What this means is that you can instanciate 'Home' class to ANY kind of class object you want; say Dog(), Cat(), an Integer(), or a String(). Example;
             - Home<Dog> dogHome = new Home<>(new Dog(), new Dog());
             - Home<Cat> catHome = new Home<>(new Cat(), new Cat());
             - Home<String> stringHome = new Home<>(new String(), new String());


    - <T extends Animal> -> upper bounded Type parameter
        - What this means is, you can instanciate your 'Home' class to Animal or Animal subclass class object really; Animal(), Dog(), Cat(), IndianCat() or Husky() are the only once allowed. Example;
             - Home<Dog> dogHome = new Home<>(new Dog(), new Dog());  // Works perfect
             - Home<Dog> dog1Home = new Home<>(new Husky(), new Dog());  // Works perfect
             - Home<Cat> catHome = new Home<>(new Cat(), new Cat());  // Works perfect


        - At this point when you try to instanciate 'Home' class with any other bound; say String(), Object(), Integer(), it will cause a "Bound mismatch" exception 
             - Home<String> stringHome = new Home<>(new String(), new String()); // Bound mismatch
             - Home<Integer> integerHome = new Home<>(new Integer(10), new Integer(10)); // Bound mismatch


        - When you try to get something above the 'Animal' say 'Creature' or 'Object', You'll also get the same "Bound mismatch"
             - Home<Creature> creatureHome = new Home<>(new Creature(), new Creature()); // Bound mismatch
             - Home<Object> objectHome = new Home<>(new Object(), new Object()); // Bound mismatch


    - Extends is used to specify the upperbound

 */

public class _02_Extends {

    public static void main(String[] args) {

        Home<Dog> dogHome = new Home<>(new Dog(), new Dog());
        Home<Dog> dog1Home = new Home<>(new Husky(), new Dog());
        Home<Cat> catHome = new Home<>(new Cat(), new Cat());

        System.out.println(dogHome);
        System.out.println(dog1Home);
        System.out.println(catHome);

        System.out.println(" --- --- --- Unbounded Type --- --- --- ");

        Home1<String> stringHome1 = new Home1<>(new String(), new String()); // Bound mismatch
        Home1<Integer> integerHome1 = new Home1<>(new Integer(10), new Integer(10)); // Bound mismatch
        Home1<Creature> creatureHome1 = new Home1<>(new Creature(), new Creature()); // Bound mismatch
        Home1<Object> objectHome1 = new Home1<>(new Object(), new Object()); // Bound mismatch

        System.out.println(stringHome1);
        System.out.println(integerHome1);
        System.out.println(creatureHome1);
        System.out.println(objectHome1);
    }
}

class Home<T extends Animal> { // <T extends Animal> -> BOUNDED TYPE PARAMETER
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

class Home1<T> { // <T> -> UNBOUNDED TYPE PARAMETER
    private T animal1;
    private T animal2;

    public Home1(T animal1, T animal2) {
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