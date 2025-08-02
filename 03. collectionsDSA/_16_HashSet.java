/*

    NOTES:
    Set<Integer> A = new HashSet<>(List.of(1, 2, 3, 4));
    Set<Integer> B = new HashSet<>(List.of(3, 4, 5, 6));

        - A.containsAll(B); // false → A doesn't have 5, 6
        - A.addAll(B); // A becomes [1, 2, 3, 4, 5, 6]
        - A.removeAll(B); // A becomes [1, 2] (removes 3, 4, 5, 6)
        - A.retainAll(B); // A becomes [3, 4] (keeps only common)


    NOTE: 
    - B always remains unchanged
    - In a hashset the deletion & addition take the same amount of time, O(1) on average
    - HashSet is not ordered, so the order of elements may change
    - HashSet cannot be sorted
    - HashSet does not allow duplicate elements

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _16_HashSet {

    public static void main(String[] args) {

        Set<Integer> hashSet = new HashSet<>();

        // Adding elements to the HashSet
        hashSet.add(11);
        hashSet.add(21);
        hashSet.add(31);
        hashSet.add(21); // Duplicate, will not be added

        // Displaying the HashSet
        System.out.println("HashSet: " + hashSet);

        // Adding set from a collection(ArrayList)
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

        // Clearing the HashSet
        anotherSet.clear();
        System.out.println("After clearing set: " + anotherSet);

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
        set1.add(88);

        System.out.println("Before removeAll");
        System.out.println("set1: " + set1); // set1: [64, 88, 44]
        System.out.println("set2: " + set2); // set2: [64, 54, 44]
        System.out.println();

        set1.removeAll(set2);
        System.out.println("After removeAll");
        System.out.println("set1: " + set1); // set1: [88]
        System.out.println("set2: " + set2); // set2: [64, 54, 44]

        // System.out.println("Before retainAll");
        // System.out.println("set1: " + set1); // set1: [64, 88, 44]
        // System.out.println("set2: " + set2); // set2: [64, 54, 44]
        // System.out.println();

        // set1.retainAll(set2);
        // System.out.println("After retainAll");
        // System.out.println("set1: " + set1); // set1: [64, 44]
        // System.out.println("set2: " + set2); // set2: [64, 54, 44]

    }
}