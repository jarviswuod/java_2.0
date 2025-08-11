/*

    NOTES:
    - List<?> numberList; can be: 
        - List<Integer>
        - List<Object>
        - List<Animal>
        - List<Student>
        - List<String>
        - List<Number>
        
        The question mark <?> basically allows for any type

    - List<? extends Number> numberList; restrics to ONLY allowing Number class or subclass
        - List<Integer>
        - List<Number>
        - List<Float>
        - List<Double>

    - List.of()  -->  Generics concept
        - List.of() casts any datatype passed to it to match whatever is on the left side of the expression. Example; If a List is changed to Integer then List.of() changes the elements to match Integer objects, same rule applies if List is changed to Double, Floas, etc.

        - Simple rule, whatever is on the left is what will be assigned on the right
            - List<Integer> listIntegers = List.of(1, 2, 3, 4, 5);
            - List<Double> listDouble = List.of(1, 2, 3, 4, 5);
            - List<Float> listFloat = List.of(1, 2, 3, 4, 5);
            - List<Number> listNumber = List.of(1, 2, 3, 4, 5);


    METHOD EXPLANATION:
        void displayNumbers(List<? extends Number> numberList) {

            Number number = numberList.get(0);
                - For type safety reasons, Whatever number you try to read it will cast to Number object type


            Double number = numberList.get(0); // Type mismatch: cannot convert ? extends Number to Double
                - This is because the complier doesn't know what exactly is in the 'numberList'. You could be having an Integer or Long otherwise
                - If say you convert Number to Double then you get a compile error


            for (Number item : numberList) {
                System.out.println(item);
            }
                - Same concept applies to the loop 'Number'


            numberList.size();
                - The only methods you are allowed to access are methods in the Number(upperbound set) class that are specific to READ

            numberList.add(34);
                - No CREATE or UPDATE methods are allowed
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