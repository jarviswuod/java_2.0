/*

    NOTES:
        - Generics by default is invariant and this means that you only need to input the exact required datatype   
            - List<Number> listOfValues = new ArrayList<Number>();      // Works Perfect
            - List<Number> listOfValues = new ArrayList<Integer>();     // Won't work
            - List<Number> listOfValues = new ArrayList<Double>();      // Won't work

        - We can achieve covariance concept in generics by using the 'extends' keyword where whatever we specify as the upperbound we can accept either that exact type or subclass of that type
            - List<? extends Number> listOfVal = new ArrayList<Integer>();      // Works Perfect
            - List<? extends Number> listOfVal = new ArrayList<Number>();       // Works Perfect
            - List<? extends Number> listOfVal = new ArrayList<Double>();       // Works Perfect
            - List<? extends Number> listOfVal = new ArrayList<String>();       // Doesnot work
            - List<? extends Number> listOfVal = new ArrayList<Object>();       // Doesnot work


        - Covariance in java --> Works perfectly
            - Number int = new Integer(10);
            - Number doub = new Double(10);

        - Achieving covariance in generics
            - List<? extends Number> listOfVal = new ArrayList<Integer>();
            - List<? extends Number> listOfVal = new ArrayList<Number>();
            - List<? extends Number> listOfVal = new ArrayList<Double>();


    PROBLEM:
        - The downside of covariance in generics is that you can't (WRITE), add any element as you can in a normal List/ ArrayList
            List<Number> numberList;
                - numberList.add(1);
                - numberList.add(4.5f);
                - numberList.add(4L);
                - numberList.add(23.0);


    REASON:
        - The compiler doesn't know what type of data you will be adding, you might decide to add different type to a different list. Example;
            - Add a Double to a List of integers, which will loose it from type safety

            List<? extends Number> listOfNumbs; // = listNumbers;
            // listOfNumbs.add(1.2);
            // listOfNumbs.add(12);
            // listOfNumbs.add(2.4f);
            // listOfNumbs.add(36L);

    SOLUTION:
        - What you can safely do to the list is to READ from the list and that's how the 'extends' keyword is getting used
        - The list is some kind of mystery box where we can have any kind of List; say Integer, Double, Long, or Number. Whenever we are going to fetch something we can get Number only, that's the guarantee the complier is giving us.

                for (Number number : listOfNumbs) {
                    System.out.println(number);
                }

        - You cannot however say

                for (Integer number : listOfNumbs) { // Type mismatch:
                    System.out.println(number);
                }
            
        - This causes a Type mismatch as we have defined a List of Number to our generic List, meaning any Number could have been passed not only Integers

 */

import java.util.ArrayList;
import java.util.List;

public class _08_ProducerExtends {

    public static void main(String[] args) {

        System.out.println("------------- Number -------------");

        ArrayList<Number> listNumbers = new ArrayList<>();
        listNumbers.add(2);
        listNumbers.add(3);
        listNumbers.add(1);
        listNumbers.add(6.0);

        List<? extends Number> listOfNumbers = listNumbers;
        System.out.println(listOfNumbers);

        System.out.println("------------- Double -------------");

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(2.0);
        listDouble.add(3.0);
        listDouble.add(1.0);

        List<? extends Number> listOfDoubles = listDouble;
        System.out.println(listOfDoubles);

        System.out.println("------------- Integer -------------");

        ArrayList<Integer> listIntegers = new ArrayList<>();
        listIntegers.add(2);
        listIntegers.add(3);
        listIntegers.add(1);

        List<? extends Number> listOfInteger = listIntegers;
        System.out.println(listOfInteger);

        System.out.println();
        System.out.println();
        System.out.println();

        List<? extends Number> listOfNumbs = listNumbers;
        // listOfNumbs.add(1.2);
        // listOfNumbs.add(12);
        // listOfNumbs.add(2.4f);
        // listOfNumbs.add(36L);

        for (Number number : listOfNumbs) {
            System.out.println(number);
        }
    }
}