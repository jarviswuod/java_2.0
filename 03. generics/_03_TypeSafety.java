/*

    NOTES:
    - Type safety:
        class Home<T extends Dog> {...}

        Home<Dog> dogHuskyHome = new Home(new Dog(), new Husky());

             - If you set the upperbound to Dog, it means you can have either Dog or Dog subclasses, in this case that will be Husky class.
             - Under Home you can now have both Dog and Husky set at the same time, it's all Type safe. But you cannot add type Cat or IndianCat, it leads to compile error since Home it set to Upperbound of Dog class only


        Dog animal2 = dogHuskyHome.getAnimal2();
        System.out.println(animal2);

        Dog dog1 = new Husky();     // Same thing as

             - Type safety is not only putting staff inside the bound limit but also retrieving it. Whenever you want to retrive a value weather Dog or Husky, it will be cast to what you defined as the upperbound.
             - For type safety reasons, if you set it your bound to Dog and have Husky inside the Home instance, then if you retrieve the values you will get Dog and not 'Husky', this is because the compiler doesnot know if you gonna put a Dog class or any or it's subclass

 */

public class _03_TypeSafety {
    public static void main(String[] args) {

        Home<Dog> dogHuskyHome = new Home(new Dog(), new Husky());
        Dog animal1 = dogHuskyHome.getAnimal1();
        Dog animal2 = dogHuskyHome.getAnimal2();

        System.out.println(animal1);
        System.out.println(animal2);

        Dog dog1 = new Husky();
        System.out.println(dog1);

        Home<Animal> animalHome = new Home(new Animal(), new Animal());
        Home<Dog> dogHome = new Home(new Dog(), new Dog());
        Home<Cat> catHome = new Home(new Cat(), new Cat());
        Home<Husky> huskyHome = new Home(new Husky(), new Husky());

        animalHome.getAnimal1();
        dogHome.getAnimal1();
        catHome.getAnimal1();

        Husky animal1Husky = huskyHome.getAnimal1();
        System.out.println(animal1Husky);

    }
}

class Home<T extends Animal> {
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