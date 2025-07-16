/*
 * 
 * ArrayList/ dynamic array Class Overview
 * 
 * An ArrayList is a re-sizable array. It grows it's size to accomodate new lements and shrinks the size when the elements are removed
 * Just like arrays you can retrive elements by their index
 * Java ArrayList allos duplicate and null values
 * Java ArrayList is an ordred collection (Maintains insertion order or elements)
 * You cannot create an ArrayList of primitive types (int & char). You use boxed types like Interger, Character, Boolean
 * Java ArrayList is not sycnhronized. If multiple threads thry to modify an ArrayList at the same time, the final outcome will be non-deterministic. You must explicitly sychronize access to an ArrayList if multiple threads are gonna modity it.
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _04_ArrayListClass {
    public static void main(String[] args) {

        // Creating an ArrayList object using default constructor
        List<String> fruits = new ArrayList<>();

        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("guavas");

        System.out.println(fruits);

        // Creating an ArrayList object using Another Collection
        // 1. ArrayList(Collection c) constructor
        // 2. Adding Existing elements to a new ArrayList .addAll ()

        List<Integer> firstFivePrimeNumbers = new ArrayList<>();
        firstFivePrimeNumbers.add(2);
        firstFivePrimeNumbers.add(3);
        firstFivePrimeNumbers.add(5);
        firstFivePrimeNumbers.add(7);
        firstFivePrimeNumbers.add(11);

        List<Integer> firstTenPrimeNumbers = new ArrayList<>(firstFivePrimeNumbers);

        List<Integer> nextFivePrimeNumbers = new ArrayList<>();
        nextFivePrimeNumbers.add(2);
        nextFivePrimeNumbers.add(3);
        nextFivePrimeNumbers.add(5);
        nextFivePrimeNumbers.add(7);
        nextFivePrimeNumbers.add(11);

        firstTenPrimeNumbers.addAll(nextFivePrimeNumbers);
        System.out.println(firstTenPrimeNumbers);
    }
}
