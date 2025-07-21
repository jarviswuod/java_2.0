/*
    
    NOTES:

    HashSet class Overview
     - HashSet implements Set interface.
     - HashSet internally uses a HashMap to store the elements
     - HashSet allows only one null value
     - HashSet cannot contain duplicate elements
     - HashSet is an unordered collection. It does not maintain the order in which elements are added
     - Hashset is not thread-safe. You must explicitly synchronize access.
     - HashSet is faster than TreeSet than LinkedHashSet because it does not maintain the order of elements.
    
 */

import java.util.HashSet;
import java.util.Set;

public class _14_HashSet {

    public static void main(String[] args) {
        nullValuesDemo();
        duplicateElementsDemo();
        unorderedDemo();
    }

    // Set can contain only one null value
    private static void nullValuesDemo() {
        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        System.out.println(set);
    }

    // it is not contain duplicate elements
    private static void duplicateElementsDemo() {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple"); // duplicate element, will not be added
        System.out.println(set);
    }

    // It does not maintain the order of elements
    private static void unorderedDemo() {
        Set<String> set = new HashSet<>();
        set.add("banana");
        set.add("apple");
        set.add("orange");
        set.add("guava");
        set.add("kiwi");
        set.add("mango");
        set.add("papaya");
        System.out.println(set); // order may vary
    }
}
