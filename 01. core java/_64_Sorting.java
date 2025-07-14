/*
 * Comparator is an interface using which you can specify comparison on your own logic for sorting
 * 
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
