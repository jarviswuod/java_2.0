/*

    NOTES:
    - Method Inheritance on bounded Type parameter
        - If you haven't defined any bound at your Home level then you are limited by what you can do interms of accessing methods under the inheritance 'tree'. Example;
        - In our Animal class we can set any general method and by inheritance laws the method should automatically be accessed by any Animal subclass.
        - However, in generics, not setting 'bound' to Animal class makes it impossible to make any Animal specific method call. Example; If we try to access makesound(), it won't be possible despite having the the method under 'Animal', the superclass. Reason:
            - 'T' can be anything, including a String(), Integer() etc.

        - The only accessible methods under unbound <T> Type are Object class methods ONLY;
            - hashcode()
            - toString()
            - equal()
            - notify() etc

    Summary:
        - If you don't define a bound then you call only make Object method calls 
        - If you have defined the upperBound then you can make specific method calls as long as the method is within the super class of the bound class. In our case makeSound()

 */

public class _04_MethodInheritance {
    public static void main(String[] args) {

        Home<Animal> animalHome = new Home(new Animal(), new Animal());
        Home<Dog> dogHome = new Home(new Dog(), new Dog());
        Home<Cat> catHome = new Home(new Cat(), new Cat());
        Home<Husky> huskyHome = new Home(new Husky(), new Husky());

        animalHome.getAnimal1().makeSound();
        dogHome.getAnimal1().makeSound();
        catHome.getAnimal1().makeSound();
        huskyHome.getAnimal1().makeSound();

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
        animal1.makeSound();
        return animal1;
    }

    public T getAnimal2() {
        return animal2;
    }
}

class Creature {
}

class Animal extends Creature {
    public void makeSound() {
        System.out.println("Animal is making sound...");
    }
}

class Cat extends Animal {
}

class Dog extends Animal {
}

class Husky extends Dog {
}

class IndianCat extends Cat {
}