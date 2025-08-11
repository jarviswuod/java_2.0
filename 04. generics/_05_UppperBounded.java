/*

    NOTES:
    - In java variables are covariant
    - In generics variables are invariant

    - Covariance means when something is needed, a more specific thing can be assigned to you and still works perfectly
    - Invariant means when something is needed you MUST provide that very thing back and nothing else

    - We want to achieving covariance in Java generics generics
    - We want to write a method that gives back a sum of a list


    Step 1:
        - We wrote the method 'sumIntValues()' which basically takes in a List of Integers
            - public Integer sumIntValues(List<Integer> listOfInteger) {...}
        - The function 'sumIntValues()' works perfectly with our List of Integers
            - MathTest.sumNumValues(listIntegers) -> Works

        - We create another List of doubles and try to pass it inside the same function 'sumIntValues()'
            - MathTest.sumNumValues(listDouble) -> Error
        - This basically does not work because our method only works with Integers and not any other Object Type

    Step 2:
        - We create another method "sumNumValues()" this is basically aimed to solve the issue of having to deal with all kinds of numbers Object types; say Integer, Double, Float or Long. It should accept any List Object of Numbers
            - public Double sumNumValues(List<Number> listOfNumber) {...}

        - We do this to ensure that any Object Type passed is converted to a double before summing it
            - values.doubleValue();

        ISSUE:
        - This method ONLY works with with a list of Numbers and nothing else NOT even a List of Integer or Double. Keep in mind an Integer is a subtype of Number.
            - MathTest.sumNumValues(listNumbers) -> Works
            - MathTest.sumNumValues(listDouble) -> Error
            - MathTest.sumNumValues(listIntegers) -> Error

    - More explanation;
        - Covariance in java --> Works perfect
            - Number int = new Integer(10);
            - Number doub = new Double(10);

        - Covariance in generics --> Does not work
            - ArrayList<Number> intList = new ArrayList<Integer>();
            - ArrayList<Number> doubList = new ArrayList<Double>();
            - ArrayList<Number> numbList = new ArrayList<Number>();

    - Covariance;
        - Invariance in generics are not possible directly in java, this leads to introduction of unbounded Type parameter
            - public <T> Double sumAnyValues(List<T> listOfAnyVal) {...}

        - What this means is that the List can take in any Number datatype and progress it as opposed to ONLY passing the specified data. You can currently pass in a Number, Float, Double, String; basically any datatype you would wish under the same method
        - The limitation of having this method parameter as unbounded Type is that you cannot be able to access any specific 'Number' methods to perform our operation, i.e <T> can be of type String, Animal or Object, this will lead to complie error for the operation for the complier doesnot know what type of values you will be using


    - Upperbound parameter
        - This leads to the introduction of bounded Type parameter/ setting an upper bound
            - public <T extends Number> Double sumAnyVal(List<T> listOfAnyVal) {...}

        - Having an upper bound set to Number ensures ONLY List of Number or it's subclasses(Integer, Double, etc) is allowed
             - Strings are not allowed since they are not a subclass of Number
             - Objects are not allowed for the upper bound is set to 'Number' class

 */

import java.util.List;
import java.util.ArrayList;

public class _05_UppperBounded {

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
        // System.out.println(MathTest.sumIntValues(listDouble));

        System.out.println("------------- Integer -------------");

        ArrayList<Integer> listIntegers = new ArrayList<>();
        listIntegers.add(2);
        listIntegers.add(3);
        listIntegers.add(1);
        System.out.println(MathTest.sumAnyVal(listIntegers));
        System.out.println(MathTest.sumIntValues(listIntegers));
        // System.out.println(MathTest.sumNumValues(listIntegers));

    }
}

class MathTest {

    public static <T extends Number> Double sumAnyVal(List<T> listOfAnyVal) { // Deals with Number List or subclass

        double sum = 0;
        for (T values : listOfAnyVal) {
            sum += values.doubleValue();
        }

        return sum;
    }

    public static <T> Double sumAnyValues(List<T> listOfAnyVal) { // Deals with ANY List type

        double sum = 0;
        for (T values : listOfAnyVal) {
            // sum += values.doubleValue(); // unbounded type
        }

        return sum;
    }

    public static Double sumNumValues(List<Number> listOfNumber) { // ONLY deals with Number List

        double sum = 0;
        for (Number values : listOfNumber) {
            sum += values.doubleValue();
        }

        return sum;
    }

    public static Integer sumIntValues(List<Integer> listOfInteger) { // ONLY deals with Integer List

        int sum = 0;
        for (Integer values : listOfInteger) {
            sum += values;
        }

        return sum;
    }
}