/*
 If you havent defined any bound at your home level is setting it to unbound Home<T> you hare limited by what you can do interms of accessing methods inside the inheritance 'tree'

 Example lets set an example in our Animal classm say any general method(by inheritance laws, this method can be accessed by any subclasses of Animal super class)
If we dont set the 'bound' for animal. in theory we could assume that Home is bound to Animal but if we try to access/make a method call,makesound() it's not possible despite having it under Animal superclass

If <T> bound is not defined, it will not be possible to make Animal specific method call, because T can be anything , includging a String or Integer. you cannot make Animal specific method call.
The only methods you can see under unbound <T> are object class methods only, hashcode, toString, equal, notify.etc

Summary, If you dont define a bound then you cal only make Object method calls else you have to define the upperBound for you to make that specific method call, as long as it's within the super class of the bound class. 
in our case that animal1.makeSound()

Test, if you set to the bound to Dog you can still make the makeSound() method because dog is extending the Animal class which has the method defined in it



    Home<Dog> dogHuskyHome = new Home(new Dog(), new Husky());
    Dog animal2 = dogHuskyHome.getAnimal2();
    System.out.println(animal2);

If you set the upperbound to Dog, it means you can have either Dog or Dog subclasses, in this case that will be Husky class.
Under Home you can now have both DOg and Husky set at the same time, it's all type safe to do that, nb you cannot add type Cat or IndianCat, it leads to compile error since Home it set to Upperbound of Dog class only

Type safety is not only putting staff inside the bound limit but also retrieving it. Whenever you will want to retrive a value weather Dog or Husky, it will be casted to what you defined as the upperbound, for type saftely reasons hence if you set it to Dog and have Husky inside the DogHOme, when you try to retrieve you will get Dog and not Husky, this is because the compiler doesnot knwo if you gooa put a Dog class or any or its subclass

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
