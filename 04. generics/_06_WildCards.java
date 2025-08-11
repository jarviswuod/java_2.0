/*

    NOTES:
    Wild Cards <?>
        - Introducing unbounded wild card (List<?> listOfAnyVal)
        - This is an alternative for solving the generics invariance issue in generics, we ignore the generics method signature
            - public static Double sumAnyValues(List<?> listOfAnyVal) {...}
        - This means the List can be of any type we pass in.

        Problem:
            - The issue here is, just like under unbounded type( <T> ), you will be able to pass in a List of Object, String or anything else which will cause type safety.
        Solution:
            - We can solve this issue by setting a bounded wild card. List of unknown type that extends Number
                - public Double sumAnyValues(List<? extends Number> listOfAnyVal) {...}

            - This is called upper bounded Wild card


    SUMMARY:
     - Generics in java are invariant
     - We make Generics covariant by introducting;
            - The bounded Type parameter(generic signature) - <T extends Number>
            - The upper bounded wildcard - List<? extends Number>

     - We have achieved covariance using 'extends Number' keyword but we have to pass a little cost for its

 */

import java.util.ArrayList;
import java.util.List;

public class _06_WildCards {

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

    public static Double sumAnyValu(List<? extends Number> listOfAnyVal) {

        double sum = 0;
        for (Number values : listOfAnyVal) {
            sum += values.doubleValue();
        }

        return sum;
    }

    public static Double sumAnyValues(List<?> listOfAnyVal) {

        double sum = 0;
        for (Object values : listOfAnyVal) {
            // sum += values.doubleValue();
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