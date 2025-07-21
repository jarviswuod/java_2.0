/*

    NOTES:

    ArrayList(dynamic array) Class Overview
     - An ArrayList is a re-sizable array. It grows and shrinks in size
     - Just like arrays you can retrive elements by their index
     - Java ArrayList allows duplicate and null values
     - Java ArrayList is an ordered collection (Maintains insertion order or elements)
     - You cannot create an ArrayList of primitive types (int & char). You use boxed types like Interger, Character, Boolean
     - Java ArrayList is not sycnhronized. You must explicitly sychronize it's access

 */

import java.util.ArrayList;
import java.util.List;

public class _04_ArrayListClass {
    public static void main(String[] args) {

        // Creating an ArrayList object
        List<String> fruits = new ArrayList<>();

        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("guavas");

        System.out.println(fruits);

    }
}