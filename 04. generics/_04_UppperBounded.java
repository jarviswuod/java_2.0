/*
 Achieve covariance in generics

 We want to write a method that gives back a sum of a list
 Step 1:
    We wrote the method 'sumIntVal()' it basically takes in a list of Integers.
        - public Integer sumIntVal(List<Integer> listOfInteger) {...}
    The fucntion 'sumIntVal()' works perfectly with our list of Intergers
        - MathTest.sumNumValues(listIntegers)
        
    We create another list of doubles and try to pass it inside the same fucntion 'sumIntVal()'. 
        - MathTest.sumNumValues(listDouble)
    This basically doesnot work because our method only works with Integers and not any other datatype

    We create another method "sumNumValues()" this is basically aimed to solve the issue of having to deal with all kinds of data types as long as its a number, say Integer, Double, Float or Long. We want the method to accept any type of List
         - values.doubleValue();
    We do this to ensure that any datatype passed is converted to a double before summing it
        - public Double sumNumValues(List<Number> listOfNumber) {...}
    
    This method ONLY works with with a list of Numbers and nothing else NOT a list Integer or Double. Even though an Integer is a subtype of Number. In generics an ArrayList of Integer is not the superclass of ArrayList of Number
        - MathTest.sumNumValues(listNumbers) -> Works
        - MathTest.sumNumValues(listDouble) -> Error
        - MathTest.sumNumValues(listIntegers) -> Error
    
    More explanation;
        - Covariance in java --> Works perfect
            - Number int = new Integer(10);
            - Number doub = new Double(10);

        - Covariance in generics --> Does not work
            - ArrayList<Number> intList = new ArrayList<Integer>();
            - ArrayList<Number> doubList = new ArrayList<Double>();
            - ArrayList<Number> numbList = new ArrayList<Number>();
    Note:
        - In java varaibles are covariant
        - In generics variables are invariant

        - Covariance means when you need something a more specific thing can be assigned to you and works perfect
        - Invariant means when something is asked you MUST provide that very thing back and nothing else, example in  generics, it cannot be changed
    
    Invariance in generics are not possible directly in java, this leads to introduction of unbounded Type parameter as of "sumAnyValues()"
        - public <T> Double sumAnyValues(List<T> listOfAnyVal) {...}
    What this means is that the List can take in any datatype and progress as opposed to passing in a specific data type. You can currently pass in a Number, Float, Double, String; basically any datatype you would wish under the same method.
    The limitation of having this method parameter as unbounded Type is that you cannot be able to access any specific 'Number' methods to which we need to perform our operation, i.e T can be of type String, Animal or Object, this will lead to complie error for the operation for the complier doenot know what type of values you will be using. This leads to the introduction of bounded Type parameter/ setting an upper bound.
        - public <T extends Number> Double sumAnyVal(List<T> listOfAnyVal) {...}
    Having an upper bound set to Number ensures that no one will be allowed to pass in any type of List other than that of a Number or it's subclasses, Integer, Double, etc
        - Strings are not allowed since done anywhere under subclass of Number
        - Objects are not allowed for the upper bound is set to a limit of Numbers

 */

import java.util.ArrayList;
import java.util.List;

public class _04_UppperBounded {

    public static void main(String[] args) {

        System.out.println("------------- Number -------------");

        ArrayList<Number> listNumbers = new ArrayList<>();
        listNumbers.add(2);
        listNumbers.add(3);
        listNumbers.add(1);
        listNumbers.add(6.0);

        System.out.println(MathTest.sumNumValues(listNumbers));
        System.out.println(MathTest.sumAnyVal(listNumbers));

        System.out.println("------------- Double -------------");

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(2.0);
        listDouble.add(3.0);
        listDouble.add(1.0);
        System.out.println(MathTest.sumAnyVal(listDouble));
        // System.out.println(MathTest.sumNumValues(listDouble));
        // System.out.println(MathTest.sumIntVal(listDouble));

        System.out.println("------------- Integer -------------");

        ArrayList<Integer> listIntegers = new ArrayList<>();
        listIntegers.add(2);
        listIntegers.add(3);
        listIntegers.add(1);
        System.out.println(MathTest.sumAnyVal(listIntegers));
        System.out.println(MathTest.sumIntVal(listIntegers));
        // System.out.println(MathTest.sumNumValues(listIntegers));

    }
}

class MathTest {

    public static <T extends Number> Double sumAnyVal(List<T> listOfAnyVal) {

        double sum = 0;
        for (T values : listOfAnyVal) {
            sum += values.doubleValue();
        }

        return sum;
    }

    public static <T> Double sumAnyValues(List<T> listOfAnyVal) {

        double sum = 0;
        for (T values : listOfAnyVal) {
            // sum += values.doubleValue(); // unbounded type
        }

        return sum;
    }

    public static Double sumNumValues(List<Number> listOfNumber) {

        double sum = 0;
        for (Number values : listOfNumber) {
            sum += values.doubleValue();
        }

        return sum;
    }

    public static Integer sumIntVal(List<Integer> listOfInteger) {

        int sum = 0;
        for (Integer values : listOfInteger) {
            sum += values;
        }

        return sum;
    }
}