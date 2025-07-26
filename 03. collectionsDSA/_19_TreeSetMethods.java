/*
    NOTES:
     - floor
     - higher
     - lower
     - ceiling
    
    - The above methods do not work with Set class hence could not work with set1 in the example below. 
    - They only work under NavigableSet interface as they part of the methods


 */

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class _19_TreeSetMethods {

    public static void main(String[] args) {

        Set<Integer> set1 = new TreeSet<>();
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(8);
        set.add(3);

        set.add(1);
        set.add(0);
        set.add(5);

        System.out.println(set1);
        System.out.println(set);

        System.out.println(set.floor(1)); // 1
        System.out.println(set.higher(1)); // 3
        System.out.println(set.lower(1)); // 0
        System.out.println(set.ceiling(2)); // 3

    }
}
