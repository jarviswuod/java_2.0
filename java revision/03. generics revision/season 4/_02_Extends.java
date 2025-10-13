public class _02_Extends {

    public static void main(String[] args) {

        Home<Animal> homeAnimal = new Home<>(new Animal(), new Dog());
        System.out.println(homeAnimal);

        Home<Creature> homeCreature = new Home<>(new Animal(), new Creature());
        System.out.println(homeCreature);

    }
}

// class Home<T extends Animal> {
class Home<T> {

    private T firstT;
    private T secondT;

    public Home(T firstT, T secondT) {
        this.firstT = firstT;
        this.secondT = secondT;
    }

    public T getFirstT() {
        return firstT;
    }

    public T getSecondT() {
        return secondT;
    }

    @Override
    public String toString() {
        return "Home [firstT=" + firstT + ", secondT=" + secondT + "]";
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