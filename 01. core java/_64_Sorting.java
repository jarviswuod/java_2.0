/*

    NOTES:
      - Comparator is a functional interface used to define custom sorting logic
      - Useful when:
          - You don’t want to or can't modify the original class (e.g. Integer, String)
          - You want multiple ways to sort the same data

      - compare(T o1, T o2) returns:
          - positive -> o1 > o2
          - negative -> o1 < o2
          - zero     -> equal

      - Collections.sort(List, Comparator) sorts list using given logic

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _64_Sorting {
    public static void main(String[] args) {

        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                if (i % 10 > j % 10)
                    return 1;
                else
                    return -1;
            }
        };

        List<Integer> nums = new ArrayList<Integer>();
        nums.add(62);
        nums.add(54);
        nums.add(82);
        nums.add(21);
        nums.add(16);

        Collections.sort(nums, com);

        System.out.println(nums);
    }
}