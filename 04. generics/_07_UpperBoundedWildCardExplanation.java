/*

This can be an interview question or a concept I can runto when coding
The problem we are solving is that we can have a more general, an API method that can grab any list which is a number or annything that extends a Number.
If you dont have the concepts of generics, you might think of having to overload the same method to allow different datatypes parameters say Integer, Double, etc

    - public Double sumAnyValues(List<Long> listOfAnyVal) {...}
    - public Double sumAnyValues(List<Double> listOfAnyVal) {...}
    - public Double sumAnyValues(List<Number> listOfAnyVal) {...}
    - public Double sumAnyValues(List<Integer> listOfAnyVal) {...}

 This cannot work, you cannot have overloaded methods with list of different parameters because in runtime the generics aspect will be striped off. All these are complite time thing to help us solve for type safety for adding or getting only a specific type of element. At the end of the day of the 4 overloaded methods are the same in runtime

 NOTE:
    - Generics is a complile time concept only and gets stripped off in runtime

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

        System.out.println(MathTest.sumAnyValues(listNumbers));

        System.out.println("------------- Double -------------");

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(2.0);
        listDouble.add(3.0);
        listDouble.add(1.0);
        System.out.println(MathTest.sumAnyValues(listDouble));

        System.out.println("------------- Integer -------------");

        ArrayList<Integer> listIntegers = new ArrayList<>();
        listIntegers.add(2);
        listIntegers.add(3);
        listIntegers.add(1);
        System.out.println(MathTest.sumAnyValues(listIntegers));

    }
}

class MathTest {

    public static Double sumAnyValues(List<? extends Number> listOfAnyVal) {

        double sum = 0;
        for (Number values : listOfAnyVal) {
            sum += values.doubleValue();
        }

        return sum;
    }
}