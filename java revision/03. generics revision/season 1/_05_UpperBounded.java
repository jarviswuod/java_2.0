/*

    NOTES:
    - Invariance:
        - Only accepting the exact match needed
        -  Allows for both READ and WRITE

    - Covariance:
        - Achieved by using 'extends' keyword
        - Only does READ
            - Read under what is defined as the upperbound
            - Doesnot allow WRITE because it doesnot know what Type will be passed to it to begin with, say Integer, yet you adding Double or String objects


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

    public static int sumOfInt(List<Integer> intList) {

        intList.add(90);

        int sum = 0;
        for (Integer integer : intList) {
            sum += integer;
        }
        return sum;
    }
}