/*
Home<T> - unbound generics - If you haven't defined any bound at your Home level then you are limited by what you can do interms of accessing methods under the inheritance 'tree'
 Example: In our Animal class we can set any general method and by inheritance laws the method will automatically be accessed by any Animal subclass.
If we don't set the 'bound' to Animal class, in theory we could assume that Home is bound to Animal but if we try to access any method call, in this case, makesound(). It's not possible despite having it under Animal superclass
If <T> bound is not defined, it will not be possible to make Animal specific method call, because 'T' can be anything, including a String, Integer etc. It's not possible to make any Animal specific method call.
The only methods you can see under unbound <T> are Object class methods only, hashcode, toString, equal, notify etc

Summary:
    - If you don't define a bound then you call only make Object method calls 
    - If you have defined the upperBound then you to make specific method calls as long as the method is within the super class of the bound class. In our case makeSound()

Test, if you set to the bound to Dog you can still access the makeSound() method because Dog is a class extending the Animal class which has the makeSound() method defined in it

    class Home<T extends Dog> {...}

    Home<Dog> dogHuskyHome = new Home(new Dog(), new Husky());
    Dog animal2 = dogHuskyHome.getAnimal2();
    System.out.println(animal2);

If you set the upperbound to Dog, it means you can have either Dog or Dog subclasses, in this case that will be Husky class.
Under Home you can now have both DOg and Husky set at the same time, it's all type safe to do that, but you cannot add type Cat or IndianCat, it leads to compile error since Home it set to Upperbound of Dog class only

Type safety is not only putting staff inside the bound limit but also retrieving it. Whenever you want to retrive a value weather Dog or Husky, it will be cast to what you defined as the upperbound.
For type safety reasons, if you set it your bound to Dog and have Husky inside the Home instance, then if you retrieve the values you will get Dog and not 'Husky', this is because the compiler doesnot know if you gonna put a Dog class or any or it's subclass

 */

public class _03_MethodInheritance {
    public static void main(String[] args) {

        Home<Animal> animalHome = new Home(new Animal(), new Animal());
        Home<Dog> dogHome = new Home(new Dog(), new Dog());
        Home<Cat> catHome = new Home(new Cat(), new Cat());
        Home<Husky> huskyHome = new Home(new Husky(), new Husky());

        animalHome.getAnimal1();
        dogHome.getAnimal1();
        catHome.getAnimal1();

        Husky animal1 = huskyHome.getAnimal1();
        System.out.println(animal1);

        Home<Dog> dogHuskyHome = new Home(new Dog(), new Husky());
        Dog animal2 = dogHuskyHome.getAnimal2();

        System.out.println(animal2);

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
