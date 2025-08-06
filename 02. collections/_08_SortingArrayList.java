/*

    NOTES
    - Sorting primitive datatype
        - sort()
        - reverse()

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _08_SortingArrayList {
    public static void main(String[] args) {

        // Sorting primitive Datatype
        List<Integer> list = new ArrayList<Integer>();

        list.add(12);
        list.add(23);
        list.add(66);
        list.add(84);
        list.add(45);
        list.add(98);

        Collections.sort(list); // ascending order
        System.out.println(list);

        Collections.reverse(list); // descending order
        System.out.println(list);

    }
}
