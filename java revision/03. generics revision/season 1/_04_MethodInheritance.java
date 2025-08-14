/*

    NOTES:
    - If you don't define a bound then you call only make Object method calls compilor assumes <T> accepts any object including a String(), Integer() etc. this makes it impossible to know what methods to offer to the object.
            - Exception in thread "main" java.lang.NoSuchMethodError: 

    - If you have defined the upperBound then you can make specific method calls as long as the method is within the super class of the bound class. In our case makeSound()
            - animalHome.getAnimal2().makeSound();

 */

public class _04_MethodInheritance {
    public static void main(String[] args) {

        Home<Animal> animalHome = new Home<>(new Animal(), new Dog());
        Home<Dog> dogHome = new Home<>(new Dog(), new Husky());
        Home<Cat> catHome = new Home<>(new Cat(), new IndianCat());
        Home<Husky> huskyHome = new Home<>(new Husky(), new Husky());

        animalHome.getAnimal2().makeSound();
        dogHome.getAnimal2().makeSound();
        catHome.getAnimal2().makeSound();
        huskyHome.getAnimal2().makeSound();

    }
}

class Home<T extends Animal> {
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
    public void makeSound() {
        System.out.println("Animal is making sound...");
    }
}

class Dog extends Animal {
}

class Husky extends Dog {
}

class Cat extends Animal {
}

class IndianCat extends Cat {
}