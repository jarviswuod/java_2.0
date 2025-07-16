/*
 * Collection Hierarchy
 * --> List
 * --- --- ArrayList
 * --- --- LinkedList
 * --- --- Vector
 * --- --- Stack
 * 
 * --> Queue
 * --- --- PriorityQueue
 * ---> Deque
 * --- --- ArrayDeque
 * 
 * --> Set
 * --- --- HashSet
 * --- --- LinkedHashSet
 * ---> SortedSet
 * --- --- TreeSet
 * 
 * 
 * Map Hierarchy
 * --- --- HashMap
 * --- --- LinkedHashMap
 * --- --- Hashtable
 * ---> SortedMap
 * --- --- TreeMap
 * 
 */

import java.util.ArrayList;
import java.util.Collection;

public class _02_Collection {
    public static void main(String[] args) {

        Collection<String> fruits = new ArrayList<>();

        fruits.add("banana");
        fruits.add("Mangoes");
        fruits.add("Apples");
        fruits.add("Oranges");
        System.out.println(fruits);

        fruits.remove("Mangoes");
        System.out.println(fruits);

        fruits.contains("Apples");

        fruits.forEach(fruit -> System.out.println(fruit));

        fruits.clear();

        System.out.println(fruits);

    }
}
