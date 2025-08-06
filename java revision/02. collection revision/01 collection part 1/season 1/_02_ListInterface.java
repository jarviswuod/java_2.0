/*

    OFFHEAD NOTES:
    - Allow null values
    - Allow duplicate values
    - Elements are ordered just an array
    - Order of elements is maintaned (insertion)

    - List implementations 
        - ArrayList
        - LinkedList
        - Vector
        - Stack

 */

import java.util.ArrayList;
import java.util.List;

public class _02_ListInterface {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(24);
        list.add(124);
        list.add(16);
        list.add(35);
        list.add(42);
        list.add(null);

        System.out.println(list);

    }
}
