/*

    NOTES:
    - toArray(new Integer[0]) -> You can pass any size really
    - Whenever you pass the same size as the arrayList to be converted, it's okay too
    - If you pass a bigger value than the ArrayList, the values will be copied and the remaining spots will be null, NOT a good convention
    - BEST PRACTISE - If you pass a small size than the ArrayList length, then a new Array is created with exactly the same length as the ArrayList

 */

import java.util.ArrayList;
import java.util.List;

public class _07_ToArrayMethod {

    public static void main(String[] args) {

        List<Integer> alist = new ArrayList<>();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        alist.add(2);

        Integer[] arr = alist.toArray(new Integer[0]);
        for (int value : arr) {
            System.out.println(value);
        }
    }
}