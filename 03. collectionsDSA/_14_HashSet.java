/*
    NOTES:
     - retainAll() doenot touch the set you pass to it(parameter) but it modifies the set on which you call it
     - removeAll() removes all the elements that are present in the set you pass to it(parameter) from the set on which you call it
     - 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _14_HashSet {

    public static void main(String[] args) {

        Set<Integer> hashSet = new HashSet<>();

        // Adding elements to the HashSet
        hashSet.add(11);
        hashSet.add(21);
        hashSet.add(31);
        hashSet.add(21); // Duplicate, will not be added

        // Displaying the HashSet
        System.out.println("HashSet: " + hashSet);

        // Addint set from another collection(ArrayList)
        List<Integer> list = new ArrayList<>();
        list.add(29);
        list.add(59);

        Set<Integer> anotherSet = new HashSet<>();
        anotherSet.add(44);
        anotherSet.add(54);
        anotherSet.addAll(list);
        System.out.println("After adding another set: " + anotherSet);

        // Removing an element from the HashSet
        anotherSet.remove(54);
        System.out.println("After removing 54: " + anotherSet);

        // Checking if an element exists in the HashSet
        System.out.println("Contains 44? " + anotherSet.contains(44));
        System.out.println("Contains 54? " + anotherSet.contains(54));

        // Clearing the HashSet
        anotherSet.clear();
        System.out.println("After clearing set: " + anotherSet);

        System.out.println();
        System.out.println();
        System.out.println();

        // Retaining elements in the HashSet
        Set<Integer> set2 = new HashSet<>();

        set2.add(44);
        set2.add(54);
        set2.add(64);

        Set<Integer> set1 = new HashSet<>();
        set1.add(44);
        set1.add(64);

        // System.out.println("Before removeAll");
        // System.out.println("set1: " + set1);
        // System.out.println("set2: " + set2);
        // System.out.println();

        // set1.removeAll(set2);
        // System.out.println("After removeAll");
        // System.out.println("set1: " + set1);
        // System.out.println("set2: " + set2);

        System.out.println("Before retainAll");
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println();

        set2.retainAll(set1);
        System.out.println("After retainAll");
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);

    }
}
