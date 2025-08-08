/*
Introducing unbounded wild card (List<?> listOfAnyVal)
 Another alternative for solving the generics invariance issue is ignoring the generics method signature.
 This can be as shown in 'sumAnyValues()' method
    - public static Double sumAnyValues(List<?> listOfAnyVal) {...}
Having List set to a question mark basically mean that the list can be of any type we pass in. The issue here is that you will be able to pass in a List of Object, String or anything else which will cause type safety.

We can solve this issue by setting a bounded wild card
    - public Double sumAnyValues(List<? extends Number> listOfAnyVal) {...}
This is called upper bounded Wild card (List<? extends Number> listOfAnyVal)

List of unknown type that extends Number

 */

import java.util.ArrayList;
import java.util.List;

public class _05_WildCards {

    public static void main(String[] args) {

        System.out.println("------------- Number -------------");

        ArrayList<Number> listNumbers = new ArrayList<>();
        listNumbers.add(2);
        listNumbers.add(3);
        listNumbers.add(1);
        listNumbers.add(6.0);

        System.out.println(MathTest.sumAnyValues(listNumbers));
        System.out.println(MathTest.sumAnyVal(listNumbers));

        System.out.println("------------- Double -------------");

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(2.0);
        listDouble.add(3.0);
        listDouble.add(1.0);
        System.out.println(MathTest.sumAnyValues(listDouble));
        System.out.println(MathTest.sumAnyVal(listDouble));

        System.out.println("------------- Integer -------------");

        ArrayList<Integer> listIntegers = new ArrayList<>();
        listIntegers.add(2);
        listIntegers.add(3);
        listIntegers.add(1);
        System.out.println(MathTest.sumAnyValues(listIntegers));
        System.out.println(MathTest.sumAnyVal(listIntegers));

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

    public static <T extends Number> Double sumAnyVal(List<T> listOfAnyVal) {

        double sum = 0;
        for (T values : listOfAnyVal) {
            sum += values.doubleValue();
        }

        return sum;
    }
}