/*

    NOTES:
    - floor()
    - higher()
    - lower()
    - ceiling()

    - The above methods do not work with Set class hence could not work with set1 in the example below
    - They only work under NavigableSet interface as they part of the methods

 */

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class _21_TreeSet {

    public static void main(String[] args) {

        Set<Integer> set1 = new TreeSet<>();
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(88);
        set.add(33);

        set.add(11);
        set.add(00);
        set.add(55);

        System.out.println(set1);
        System.out.println(set); // [0, 11, 33, 55, 88]

        System.out.println(set.floor(11)); // 11
        System.out.println(set.higher(11)); // 33
        System.out.println(set.lower(11)); // 0
        System.out.println(set.ceiling(22)); // 33
    }
}