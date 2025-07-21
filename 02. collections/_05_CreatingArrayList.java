/*

    NOTES:
    
    Creating an ArrayList
        1. Using default constructor
        2. Using another Collection
            a) ArrayList(Collection c) constructor
            b) Using ArrayList .addAll()

 */

import java.util.ArrayList;
import java.util.List;

public class _05_CreatingArrayList {
    public static void main(String[] args) {

        // Using default constructor
        List<Integer> firstFivePrimeNumbers = new ArrayList<>();
        firstFivePrimeNumbers.add(2);
        firstFivePrimeNumbers.add(3);
        firstFivePrimeNumbers.add(5);
        firstFivePrimeNumbers.add(7);
        firstFivePrimeNumbers.add(11);
        System.out.println(firstFivePrimeNumbers);

        // Using Another Collection
        // a. ArrayList(Collection c) constructor
        List<Integer> firstTenPrimeNumbers = new ArrayList<>(firstFivePrimeNumbers);

        List<Integer> nextFivePrimeNumbers = new ArrayList<>();
        nextFivePrimeNumbers.add(2);
        nextFivePrimeNumbers.add(3);
        nextFivePrimeNumbers.add(5);
        nextFivePrimeNumbers.add(7);
        nextFivePrimeNumbers.add(11);

        // b. Adding Existing elements to a new ArrayList .addAll()
        firstTenPrimeNumbers.addAll(nextFivePrimeNumbers);
        System.out.println(firstTenPrimeNumbers);
    }
}