/*

 List<?> numberList; can be: 
     - List<Integer>
     - List<Object>
     - List<Animal>
     - List<Student>
     - List<String>
     - List<Number>
    
    The question mark <?> basically allows for any type

 List<? extends Number> numberList; restrics to only allowing Number class or subclasses
     - List<Integer>
     - List<Number>
     - List<Float>
     - List<Double>
 - The of() casts any datatype you pass to it to match whatever you have on the left side of the expression, i.e where you are assigning it to hence if i change List to Integer, then List.of() changes its the elements to match the Integer, same thing happens if I change it to Double, Floas, etc.
 - Simple rule, whatever I have on the left is what on the right will be. Generics concept.

     - List<Integer> listIntegers = List.of(1, 2, 3, 4, 5);
     - List<Double> listIntegers = List.of(1, 2, 3, 4, 5);
     - List<Float> listIntegers = List.of(1, 2, 3, 4, 5);
     - List<Number> listIntegers = List.of(1, 2, 3, 4, 5);


    void displayNumbers(List<? extends Number> numberList) {

        For type safety reasons, Whatever number you try to read it will cast to number and nothing ELSE

        Number number = numberList.get(0);


        Type mismatch: cannot convert ? extends Number to Double... This is because the complier doesnot know what excactly it is in the 'numberList'. You could be having an Integer or Long instead otherwise

        If say you convert Number to Double then you get a compile error

        Double number = numberList.get(0);


        Same concept applies to the loop 'Number'

        for (Number item : numberList) {
            System.out.println(item);
        }

        numberList.size();
        The only methods you are allowed to access are methods in the Number(upperbound set ) class that are specific to READ

        numberList.add(34);
        No CREATE or UPDATE methods are allowed.  If you had Animal set to upper bound in this case, then the ONLY the READ methods would be of type Animal

    }
    
 */

import java.util.ArrayList;
import java.util.List;

public class _09_ProducerExtendsPractise {
    public static void main(String[] args) {

        System.out.println("--- ---  Numbers  --- ---");
        List<Number> listNumbers = new ArrayList<>();
        listNumbers.add(1.0);
        listNumbers.add(2.2);
        listNumbers.add(3.2);
        displayNumbers(listNumbers);

        System.out.println("--- ---  Integers  --- ---");
        List<Integer> listIntegers = List.of(1, 2, 3, 4, 5);
        displayNumbers(listIntegers);

        System.out.println("--- ---  Doubles  --- ---");
        List<Double> listDoubles = new ArrayList<>();
        listDoubles.add(1.0);
        listDoubles.add(2.0);
        listDoubles.add(3.0);
        displayNumbers(listDoubles);

    }

    public static void displayNumbers(List<? extends Number> numberList) {

        for (Number item : numberList) {
            System.out.println(item);
        }
    }
}