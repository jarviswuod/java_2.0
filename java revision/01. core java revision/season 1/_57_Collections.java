/*

    OFFHEAD NOTES:
    - Collections: Utility class with static methods to work on Collection types
    - Collection: Root interface for List, Set, and Queue

        Lists
            ArrayList class
            LinkedList class
            
        Sets
            HashSet
            SortedSet Interface -> MaviagableSet Interface -> TreeSet class

        Queue
            Deque -> ArrayDeque

    - Maps
         HashMap
         Hashtable
         TreeMap


    RULES:
        - Always code against the interface (List/Set/Map over concrete types in declarations) -> Good practise
        - add()
        - remove()
        - addAll()
        - removeAll()
        - clear()
        - set()
        - set(int , position)
        - 2 ways of creating Collection  class
            - Using the contructor -> new ArrayList<>();
            - Using any collection interface set class new ArrayList<>(Collection collection);


        ADDED:
            - get(int index) – for Lists
            - contains() – check if element exists
            - containsAll() – check multiple existence
            - retainAll() – keep common elements
            - isEmpty() – check if collection is empty
            - size() – get total elements
            - iterator() – for loop traversal

 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class _57_Collections {

    public static void main(String[] args) {

        Collection<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list.add(12);
        list.add(22);
        list.add(36);
        list.add(48);

        System.out.println(list);
        System.out.println(list1);

        for (int value : list) {
            System.out.println(value);
        }

    }
}