/*

    NOTES:
    - Invariance:
        - Only accepting the exact match needed
        - Allows for both READ and WRITE

                public Integer sumIntValues(List<Integer> listOfInteger) {
                    listOfInteger.add(12);
                    listOfInteger.add(24);
                    listOfInteger.add(44);
                    
                    int sum = 0;
                    for (Integer values : listOfInteger) {
                        sum += values;
                    }
                    return sum;
                }

                System.out.println(sumNumValues(listIntegers));

    - Covariance:
        - Achieved by using 'extends' keyword
        - Only does READ
            - Read under what is defined as the upperbound
            - Doesnot allow WRITE because it doesnot know what Type will be passed to it to begin with, say Integer, yet you adding Double or String objects

                public static <T extends Number> Double sumAnyVal(List<T> listOfAnyVal) {

                    double sum = 0;
                    for (T values : listOfAnyVal) {
                        sum += values.doubleValue();
                    }

                    return sum;
                }


    - More explanation;
        - Covariance in java --> Works perfect
            - Number int = new Integer(10); // Works PERFECT
            - Number doub = new Double(10); // Works PERFECT

        - Covariance in generics --> Does not work
            - ArrayList<Number> numbList = new ArrayList<Number>(); // Works PERFECT
            - ArrayList<Number> intList = new ArrayList<Integer>(); // Type mismatch:
            - ArrayList<Number> doubList = new ArrayList<Double>(); // Type mismatch:

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _05_UpperBounded {

    public static void main(String[] args) {
        // ArrayList<Integer> listIntegers= Arrays.asList(21,43,56,12);
        List<Integer> listIntegers = new ArrayList<>(Arrays.asList(21, 43, 569, 12));
        // List<Integer> listIntegers = new ArrayList<>(List.of(21, 43, 56, 12));
        System.out.println(sumOfInt(listIntegers));

    }

    public static <T extends Number> double sumOfNumParam(List<T> numList) {

        double sum = 0;
        for (T number : numList) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static double sumOfDouble(List<Number> doubleList) {

        doubleList.add(90);

        double sum = 0;
        for (Number number : doubleList) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static int sumOfInt(List<Integer> intList) {

        intList.add(90);

        int sum = 0;
        for (Integer integer : intList) {
            sum += integer;
        }
        return sum;
    }
}