/*
 We can achieve covariance in generics by use of extends keyword.
 Generics by default is invaraint and this means that you only need to input the exact required datatype into it   
    - List<Number> listOfValues = new ArrayList<Number>(); // works
    - List<Number> listOfValues = new ArrayList<Integer>(); // Won't work
    - List<Number> listOfValues = new ArrayList<Double>(); // Won't work
 We can achieve covaraince concept in generics by using the extends keyword where whatever we specify as the upperbound we can accpet either that exact type or subclass of that type
    List<? extends Number> listOfVal = new ArrayList<Integer>(); // works
    List<? extends Number> listOfVal = new ArrayList<Number>(); // works
    List<? extends Number> listOfVal = new ArrayList<Double>
    (); // works
    List<? extends Number> listOfVal = new ArrayList<String>(); // Doesnot work
    List<? extends Number> listOfVal = new ArrayList<Object>(); // Doesnot work
 By this we can assign a list of Integer, Double, Long, Float to a List of Number. This is called covariance
 List of any unknown type that extends Number. Where a more general type is accepted as a NUmber, we can give a substitute. offer a more specific type

    - Covariance in java --> Works perfect
        - Number int = new Integer(10);
        - Number doub = new Double(10);

    - Achieving covariance in generics
        - List<? extends Number> listOfVal = new ArrayList<Integer>();Number int = new Integer(10);
        - List<? extends Number> listOfVal = new ArrayList<Number>();Number doub = new Double(10);
        - List<? extends Number> listOfVal = new ArrayList<Double>();

 This however comes at a cost
 You cannot add any element as you could with normal List or ArrayList
    List<Number> numberList;
    numberList.add(1);
    numberList.add(4.5f);
    numberList.add(4L);
    numberList.add(23.0);

 If you are using 'extends' you cannot WRITE to the list, all you ca be able to do is to READ from the List
 You cannot add to the list because, the compiler doesnot know what type of data you will be adding, you might decide to add different lists, example, add a Double to a List of integers, which will loose it from type safety


    List<? extends Number> listOfNumbs; // = listNumbers;
    // listOfNumbs.add(1.2);
    // listOfNumbs.add(12);
    // listOfNumbs.add(2.4f);
    // listOfNumbs.add(36L);

 What you can safely do to the list is to READ from the list. That;s how the 'extends' keyword is getting used, the list is some kind of mystery box where we can have any kind, say Integer,, Double, Long, or Number>. Whenever we are going to fetch something we can get Number only, thats the guarantee teh complier is giving us because the complier is giving us the types of T/unknown.

    for (Number number : listOfNumbs) {
        System.out.println(number);
    }

 You cannot however say

    for (Integer number : listOfNumbs) { // Type mismatch:
        System.out.println(number);
    }
        
 Beacause it causea a Type mismatch it causes a mismatch aas we have defined a list of Number to our generic List, meaning any Number could have been passed not only Integers

 NOTE:
 - 'extends' is used for reading purpose/used as a producer

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