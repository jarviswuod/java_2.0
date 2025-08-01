/*

    NOTES:
        - Collections: Utility class with static methods to work on Collection types
        - Collection: Root interface for List, Set, and Queue

        1. List (ordered, allows duplicates)
            - ArrayList
            - LinkedList

        2. Set (no duplicates, unordered or sorted)
            - HashSet
            - TreeSet

        3. Queue (FIFO or customized ordering)
            - ArrayDeque
            - LinkedList

        4. Map (key-value pairs, not part of Collection)
            - HashMap
            - TreeMap
            - Hashtable


        - By default collections receive object types (Integer, String, Character, etc.)
        - You hace to explicitly use <Integer> object when initiating the collection
             1. To prevent errors (Syntax)
             2.  Iteration down the line

 */

import java.util.ArrayList;
import java.util.Collection;

public class _60_Collections {

    public static void main(String[] args) {

        Collection<Integer> nums = new ArrayList<>();

        nums.add(6);
        nums.add(9);
        nums.add(5);
        nums.add(8);
        nums.add(2);
        // nums.add("5"); // Collection<Integer> is not applicable for (String)

        // for (Object integer : nums) {
        for (Integer integer : nums) {
            System.out.println(integer);
        }
    }
}