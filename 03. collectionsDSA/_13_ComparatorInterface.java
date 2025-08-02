/*

    NOTES:
    - Remember when we did sorting using the Integer wrapper class using the PriorityQueue. It was all possible because the Integer wrapper class implements Comparable interface and has it's compareTo() set too
    - The issue in the Integer class arises, the way the compareTo() works is in ascending order. And that's why we could only get the bottom 2 elements first, instead of the first 2 elements. 
    - In order to get the top 2 elements we need to change the compareTo() method of the Integer class which we are not allowed to access because Interger is a java package and we can't make change to that
        - It's not also a good way to handle, we are the clients using the class, we cannot run and change the internals of the class

    - Comparator Interface comes into place when we want to change sorting mechanism in the Interger class or our custom class

    - We need to implement the Comparator interface in a separate class and override it's compare() method
         - The compare() method takes 2 parameter objects

    - The difference between the compareTo() in Comparable interface and compare() in Comparator interface.
         - Since the compareTo() method is within our class, we already have the 'this' object predefined, meaning we only need one more object to compare it against
         - For compare() in the Comparator interface. The interface is implemented on the Comparator class and the compare() method has nothing to compare itself to, leading to need of 2 parameters to compare against each other



    class MyCustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer arg0, Integer arg1) {
            return arg1 - arg0;
        }
    }

    - To use/ consume the sorting, we create a PriorityQueue which takes a constructor which will be our concrete Comparator class
         - We will just have to instanciate it as
            PriorityQueue<Integer> classMarks = new PriorityQueue<>(new MyCustomComparator());

        - Alternatively we can use lambda expressions
            PriorityQueue<Integer> lambdaMarks = new PriorityQueue<>((a, b) -> b - a);


    - What happens here now is that instead of ordering that our Integer class was following, it will follow our custom ordering defined in our Comparator constructor


    - Comparable VS Comparator interface
        - Comparable Interface
            - This is ordering that our class is implementing
            - It's also called Natural ordering
            - compareTo() method override
                - PriorityQueue<Integer> orderedMarks = new PriorityQueue<>();
                - PriorityQueue<StudentsMarks> orderedMarks = new PriorityQueue<>(marks);

        - Comparator Interface
            - This is ordering are passing to the PriorityQueue
            - It's also called Total ordering
            - compare() method override
                - PriorityQueue<Integer> classMarks = new PriorityQueue<>(new MyCustomComparator());
                - PriorityQueue<Integer> lambdaMarks = new PriorityQueue<>((a, b) -> b - a);


    - Total ordering (by Comparator Interface) always has preference over Natural ordering (by Comparable Interface)

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _13_ComparatorInterface {

    public static void main(String[] args) {

        // Using a custom comparator class
        PriorityQueue<Integer> orderIntegers = new PriorityQueue<>(new MyCustomComparator());

        // Using a lambda expression
        PriorityQueue<Integer> ordIntegers = new PriorityQueue<>((a, b) -> b - a);

        orderIntegers.offer(11);
        orderIntegers.offer(22);
        orderIntegers.offer(33);
        orderIntegers.offer(44);

        // Top 2 elements
        List<Integer> top2 = new ArrayList<>();
        int index = 0;

        while (!orderIntegers.isEmpty()) {
            if (index == 2)
                break;
            top2.add(orderIntegers.poll());
            index++;
        }

        System.out.println("top2 : " + top2); // top2 : [44, 33]
        System.out.println("orderIntegers : " + orderIntegers); // orderIntegers : [22, 11]
        System.out.println("ordIntegers : " + ordIntegers); // ordIntegers : []
    }
}

class MyCustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer arg0, Integer arg1) {
        return arg1 - arg0;
    }
}
