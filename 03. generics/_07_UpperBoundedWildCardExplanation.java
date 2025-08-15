/*

    NOTES:
    - Creating a more general API method that can grab any List of Number or a List that extends Number
    - Without generics, you might attempt to overload the same method to allow different parameters types say Integer, Double, etc
        - public Double sumAnyValues(List<Long> listOfAnyVal) {...}
        - public Double sumAnyValues(List<Double> listOfAnyVal) {...}
        - public Double sumAnyValues(List<Number> listOfAnyVal) {...}
        - public Double sumAnyValues(List<Integer> listOfAnyVal) {...}

    PROBLEM:
        - Overloading a method with List of different parameters can't work
    
    REASON:
        - In runtime the generics aspect will be striped off
        - Generics are compile time factors to help us solve for type safety for either adding or getting ONLY a specific type of element and at the end, all the 4 overloaded methods are the same in runtime

    CONCLUSION:
        - Generics is a complile time concept and gets stripped off in runtime

 */

import java.util.ArrayList;
import java.util.List;

public class _07_UpperBoundedWildCardExplanation {

    public static void main(String[] args) {

        System.out.println("------------- Number -------------");

        ArrayList<Number> listNumbers = new ArrayList<>();
        listNumbers.add(2);
        listNumbers.add(3);
        listNumbers.add(1);
        listNumbers.add(6.0);

        System.out.println(sumAnyValues(listNumbers));

        System.out.println("------------- Double -------------");

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(2.0);
        listDouble.add(3.0);
        listDouble.add(1.0);
        System.out.println(sumAnyValues(listDouble));

        System.out.println("------------- Integer -------------");

        ArrayList<Integer> listIntegers = new ArrayList<>();
        listIntegers.add(2);
        listIntegers.add(3);
        listIntegers.add(1);
        System.out.println(sumAnyValues(listIntegers));

    }

    public static Double sumAnyValues(List<? extends Number> listOfAnyVal) {

        double sum = 0;
        for (Number values : listOfAnyVal) {
            sum += values.doubleValue();
        }

        return sum;
    }
}