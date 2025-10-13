/*

    NOTES:
    - This is the restriction that is gained for both adding and retriving data
    - Bound sets it apart:
        - It causes Type mismatch: Bound mismatch

    - Retriving values results into using the upperbound set
        - This is because the compiler doesnot know what class type is inside the variable feed to it

 */

public class _03_TypeSafety {

    public static void main(String[] args) {

        Home<String> stringValues = new Home<>(new String("Jarvis"), new String("Wuod"));
        Home<Object> ubjectValues = new Home<>(new Dog(), new String("Wuod"));

        Home<Object> objectValues = new Home<>(new Integer(10), new String("Wuod"));

        System.out.println(stringValues);
        System.out.println(objectValues);

        System.out.println();

        System.out.println(objectValues.getFirstT());
        System.out.println(stringValues.getFirstT());

        System.out.println(stringValues);
        System.out.println(objectValues);
        System.out.println(ubjectValues);

    }
}

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