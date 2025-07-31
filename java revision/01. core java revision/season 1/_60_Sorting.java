/*

    NOTES:
        - Arrays.aslist(...)
        - Collections.sort(Collection coll, Comparator com)

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _60_Sorting {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(12);
        list.add(22);
        list.add(16);
        list.add(11);

        System.out.println(list);

        Collections.sort(list, ((a, b) -> a - b));
        System.out.println(list);

    }
}
