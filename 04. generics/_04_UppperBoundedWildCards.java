/*
 Achieve covariance in generics

 In java it's covariance

 Number -> Integer, Double

 Covariance means when you need something a more specific thing can be assigned to you and works perfect
 Invariant means when something is asked you MUST provide that very thing back and nothing else, example in  generics, it cannot be changed

 Covariance in java --> Works perfect
    Number int = new Integer(10);
    Number doub = new Double(10);

 Covariance in generics --> Does not work
    ArrayList<Number> intList = new ArrayList<Integer>();
    ArrayList<Number> doubList = new ArrayList<Double>();
    ArrayList<Number> numbList = new ArrayList<Number>();
 
 Solution to invaraint in generics java is,,,

Generics in java are Invariant, 
In generics, when something requires a list of Numbers, we need to offer a list of Numbers NOT anything else; not Integer, not Double, none of that will work/in accepted in generics


Bounded type parameter to a bounded wild card
Upper bounded wildcard

 */

import java.util.ArrayList;
import java.util.List;

public class _04_UppperBoundedWildCards {

    public static void main(String[] args) {

        ArrayList<Number> listNumbers = new ArrayList<>();
        listNumbers.add(2);
        listNumbers.add(3);
        listNumbers.add(1);
        listNumbers.add(6.0);

        System.out.println(MathTest.sumNumValues(listNumbers));

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(2.0);
        listDouble.add(3.0);
        listDouble.add(1.0);

        // System.out.println(MathTest.sumNumValues(listDouble));

        ArrayList<Integer> listIntegers = new ArrayList<>();
        listIntegers.add(2);
        listIntegers.add(3);
        listIntegers.add(1);

        System.out.println(MathTest.sumIntValues(listIntegers));
        // System.out.println(MathTest.sumNumValues(listIntegers));

    }
}

class MathTest {
    // public static <T extends Number> Double sumAnyVals(List<T> listOfAnyVal) {
    public static Double sumAnyVals(List<? extends Number> listOfAnyVal) {

        double sum = 0;

        for (Number values : listOfAnyVal) {
            sum += values.doubleValue();
        }

        return sum;
    }

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

    public static Integer sumIntValues(List<Integer> listOfInteger) {

        int sum = 0;

        for (Integer values : listOfInteger) {
            sum += values;
        }

        return sum;
    }
}
