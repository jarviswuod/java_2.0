/*

    NOTES:
    - Typesafety
        - You can extract data in the upper bound limit of the generics or higher as it is inherited
        - You can't anything lower as in runtime it wont be know if there are other subclasses added
        - You can do Object as it's the upperclass of all classes but it;s not advisable as you cannot make specific method calls dependant on the class
        - Its too ambiguos for a call


    - Method calls:
        - Unbound makes it impossible to make method calls and you can onl ymake Object method calls as its the parent of all objects
        - Setting a bound allows to make class specific calls

 */

public class _02_Extends {

    public static void main(String[] args) {

        Home<Animal> animalHome = new Home<>(new Animal(), new Animal());
        System.out.println(animalHome.getAnimal1());
        System.out.println(animalHome.getAnimal2());

        // Home<Creature> creatureHome = new Home<>(new Animal(), new IndianCat());
        // System.out.println(creatureHome.getAnimal1());
        // System.out.println(creatureHome.getAnimal2());

        Home<Dog> dogHome = new Home<>(new Dog(), new Husky());
        System.out.println(dogHome.getAnimal1());
        System.out.println(dogHome.getAnimal2());

        Home<Animal> catHome = new Home<>(new Dog(), new Cat());
        System.out.println(catHome.getAnimal1());
        System.out.println(catHome.getAnimal2());

        // Home<String> stringHome = new Home<>(new String("s"), new String("s"));
        // System.out.println(stringHome.getAnimal1());
        // System.out.println(stringHome.getAnimal2());

        Home<? extends Animal> animalNy = new Home<>(new Animal(), new Dog());

        System.out.println(animalNy);

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

class Cat extends Animal {
}

class IndianCat extends Cat {
}

class Husky extends Dog {
}