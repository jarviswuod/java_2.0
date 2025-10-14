/*

    NOTES:
    - Unbounded level:
        - Method calls are not possible on unbound wildcards or Type Parameter
        - The only method calls one can make are object level method calls


    - Bounded level:
        - One can make specific method calls
            - The only condition is that the method has to be inherited by the upperbound or implented by it

 */

public class _04_MethodInheritance {
    public static void main(String[] args) {

        Home<Number> homeNum = new Home<>(new Float(21), new Double(90));
        homeNum.getSecondT();

        System.out.println(homeNum);

        Home<Animal> homeAnimal = new Home<>(new Animal(), new Dog());
        homeAnimal.getFirstT().makeSound();

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

    public void makeSound() {
        System.out.println("General sound");
    }
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