/*

    NOTES:

    List Interface Overview
     - List is an ordered collection (maintains insertion order)
     - Java List provides control over the position where you can insert an element
     - You can access elements by there index and also search elements in the list
     - List allows you to add duplicate elements
     - List allows you to have 'null' elements
     - List indexes start from 0, just like arrays
     - List implementation classes include ArrayList, LinkedList, Vector, Stack

 */

import java.util.ArrayList;
import java.util.List;

public class _03_ListInterface {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        // List allows you to add duplicate elements
        names.add("Jarvis");
        names.add("Jarvis");
        names.add("Jarvis");
        names.add("Jarvis");
        System.out.println(names);

        // List allows you to have "null" elements elements
        names.add(null);
        names.add(null);
        System.out.println(names);

        List<String> fruits = new ArrayList<>();

        // List follows the insertion order
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("guavas");

        // Accessing elements in a list
        System.out.println(fruits.get(0));
        System.out.println(fruits.get(1));
        System.out.println(fruits.get(3));
    }
}