/*

    NOTES:
    - getPut method PESC
    - <? extends T>
    - <? super T>
    - Invariance:
        - Means strict
        - What is needed is what should be provided
        - Generics are invariant in nature
        - Example:
            - List<Integer> listInt = new ArrayList<Integer>(); // not allowed is Number, Double
            - List<Number> listNum = new ArrayList<Number>(); // not allowed is Integer, Double
        - Rules:
            - Allows both read and write methods

    - Covariance:
        - java by default is covariant in nature
        - Example:
            - Number num1 = new Integer(10);
            - Number num2 = new Long(10l);
            - Number num3 = new Float(10);
            - Number num4 = new Double(12);

        - Making generics covariant:
            - List<? extends Number> listInteger = new ArrayList<Integer>();
            - List<? extends Number> listFloat = new ArrayList<Float>();
            - List<? extends Number> listDouble = new ArrayList<Double>();

            - List<? extends Cat> catList_ = new ArrayList<IndianCat>();
            - List<? extends Animal> animalList_ = new ArrayList<Animal>();
            - List<? extends Dog> dogList_ = new ArrayList<Husky>();


        - Rules:
            - You are only allowed to read and not Write, reason being at runtime the compiler doesnot know what will be the unknown list, you might add Integer to a list of Double

    - Contravarince:
        - Making generics contravaraint, against
        - Introduce the super keyword
            - List<? super Cat> catList = new ArrayList<Animal>();
            - List<? super Animal> animalList = new ArrayList<Animal>();
            - List<? super Dog> dogList = new ArrayList<Animal>();
        
        - Logically when you say you only accept something or above then it means you can basically add anything below it with no issues this si a concept of polymorphism in java
        - Only allows the write method. add() etc

    - Methodology
        - Type Parameter
            - bounded
                - [Lower bounded parameter] <T extends Animal> the unknown has to be either an Animal Object or it's subclasses
                - [Upper bounded parameter] <T super Number> the unknown has to be either an Number Object or Number superclass

            - unbounded
                - <T> T can be anything from a custom class to java Object class

        - Wildcards
            - bounded
                - [Lower bounded wildcard] <? extends Animal> the unknown has to be either an Animal Object or it's subclasses
                - [Upper bounded wildcard] <? super Number> the unknown has to be either an Number Object or Number superclass

            - unbounded
                - [Unbounded wildcard] <?> unknown-type can be anything from a custom class to java Object class
               
    - Type safety
        - Helps protect our generics not ony when adding values but also when reading values too.
        - It causes an Exception when something is violated example ;;; Type mismatch Exception issue


    - UPPER BOUNDED WILDCARD EXAMPLE:
        - In the example below is you have the wildcard as unbounded the you loose the ability to call methods specific to the class type you have.
        - The only methods you have access to are the Object class methods only
        - Setting the lower bound however gives you more room to make method call that are specific in our case or ones that are defined in the bound class or higher, example;
            - If we set it to Number then have Number method call we can use
            - If we have Animal class, we can call Animal methods or if it inherits any methods from it's parents

        - We set "Number" in (Number val: list) for it's safe as we can cast anything that comes out to whatever we supplied as our lower bound
            - We however cannot do anything less that that say Integer, this is because, client can have a list of double instead and that will cause an compile time error(Type mismatch) in our code

        - NOTE:
            - We cannot do any write on the list we supply, example;
                list.add(12); // Compile time exception Type mismatch
                    reason for this is , the client can supply a list of double and we try to add an Integer to it


        public static double sum(List<? extends Number> list) {
            double sum = 0;
            for (Number val : list) {
                sum += val.doubleValue();
            }
            return sum;
        }

        public static <T extends Number> double sumTypeParameter(List<T> list) {
            double sum = 0;
            for (Number val : list) {
                sum += val.doubleValue();
            }
            return sum;
        }


    - LOWER BOUNDED WILDCARD EXAMPLE:
        - We are allowed to add values/ call write methods to the upper bound class because, what this wildcards means is essentially, what will be accepted will either be the upper class or its super classes;
            - By java rules, polymorphism, we can add a subclass to a super class with not issues
        
        - We can also read from the UPPER BOUNDED WILDCARD
            - This is only possible if we set 'Object' in for(Object value : list) {} as we dont know what will be suplied as the upper bound by the client, what we don know however there is nothing above Object class in java. so basically we are getting anything from the list and we casting it to type Object instance
            - This is very much possible but not allowed in java as we only use contravariance to add values and not read values, for reading values we use 'extends' keyword in covariance

        public static void add(List<? super Dog> list) {
            list.add(new Dog()); // our upperbound class
            list.add(new Husky()); // Lower/ Upper bound subclass

            for (Object value : list) {
                System.out.println(value);
            }
        }

 */

import java.util.ArrayList;
import java.util.List;

public class _01_Intro {
    public static void main(String[] args) {

        List<? extends Number> listInteger = new ArrayList<Integer>();

        List<Integer> listInt = new ArrayList<Integer>(); // not allowed is Number, Double
        List<Number> listNum = new ArrayList<Number>(); // not allowed is Integer, Double

        Number num1 = new Integer(10);
        Number num2 = new Long(10l);
        Number num3 = new Float(10);
        Number num4 = new Double(12);

        List<? extends Number> listInteger_ = new ArrayList<Integer>();
        List<? extends Number> listFloat = new ArrayList<Float>();
        List<? extends Number> listDouble = new ArrayList<Double>();

        List<? extends Cat> catList_ = new ArrayList<IndianCat>();
        List<? extends Animal> animalList_ = new ArrayList<Animal>();
        List<? extends Dog> dogList_ = new ArrayList<Husky>();

        List<? super Cat> catList = new ArrayList<Animal>();
        List<? super Animal> animalList = new ArrayList<Animal>();
        List<? super Dog> dogList = new ArrayList<Animal>();

    }

    public static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number val : list) {
            sum += val.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double sumTypeParameter(List<T> list) {
        double sum = 0;
        for (Number val : list) {
            sum += val.doubleValue();
        }
        return sum;
    }

    public static void add(List<? super Dog> list) {
        list.add(new Dog()); // our upperbound class
        list.add(new Husky()); // Lower/ Upper bound subclass

        for (Object value : list) {
            System.out.println(value);
        }
    }
}

class Some {
}

class Animal extends Some {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

class Husky extends Dog {
}

class IndianCat extends Cat {
}