/*

    NOTES:
    - Type safety:

        - Type safety is not only putting staff inside the bound limit but also retrieving it. Whenever you want to retrive a value weather Dog or Husky, it will be cast to what you defined as the upperbound.
        - For type safety reasons, if you set it your bound to Dog and have Husky inside the Home instance, then if you retrieve the values you will get Dog and not 'Husky', this is because the compiler doesnot know if you gonna put a Dog class or any or it's subclass

            Home<Dog> dogHuskyHome = new Home<>(new Dog(), new Husky());

            Dog animal2 = dogHuskyHome.getAnimal2(); ===  Dog dog1 = new Husky();
            System.out.println(animal2);



        class Home<T extends Husky> {...} // Object extracted as of type Husky
        class Home<T extends IndianCat> {...} // Object extracted as of type IndianCat

        class Home<T extends Dog> {...} // Object extracted as of type Dog
        class Home<T extends Cat> {...} // Object extracted as of type Cat

        class Home<T extends Creature> {...} // Object extracted as of type Creature
        class Home<T extends Object> {...} // Object extracted as of type Object

        class Home<T extends String> {...} // Object extracted as of type String
        class Home<T extends Integer> {...} // Object extracted as of type Integer

 */

public class _03_TypeSafety {

    public static void main(String[] args) {

        Home<Animal> animalHome = new Home<>(new Animal(), new Dog());
        Home<Dog> dogHome = new Home<>(new Dog(), new Husky());
        Home<Cat> catHome = new Home<>(new Cat(), new IndianCat());
        Home<Husky> huskyHome = new Home<>(new Husky(), new Husky());

        System.out.println(animalHome.getAnimal2());
        System.out.println(dogHome.getAnimal2());
        System.out.println(catHome.getAnimal2());
        System.out.println(huskyHome.getAnimal2());

        System.out.println();

        Husky animal1Husky = huskyHome.getAnimal1();
        System.out.println(animal1Husky);
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
}

class Dog extends Animal {
}

class Husky extends Dog {
}

class Cat extends Animal {
}

class IndianCat extends Cat {
}