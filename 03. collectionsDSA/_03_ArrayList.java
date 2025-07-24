/*
    NOTES:
     - We always want to code against the interface as it's a good practise
     - subList() -> Shallow copies the ArrayList, Meaning the origin array is affected when you make a change to the copied array

     - Creating an ArrayList:
         - new ArrayList<>() -> Using default way
         - new ArrayList<>(Collection c) -> Using Collections

     - ArrayList Methods:
         - set()
         - add()
         - addAll()
         - indexOf()
         - lastIndexOf()
         - subList()

 */

import java.util.ArrayList;
import java.util.List;

public class _03_ArrayList {

    public static void main(String[] args) {
        List<Integer> alist = new ArrayList<>();

        alist.add(1);
        alist.add(2);
        alist.add(3);

        System.out.println("Element that gt replaced = " + alist.set(1, 100));

        List<Integer> alist2 = new ArrayList<>(alist);
        alist2.add(23);

        alist2.addAll(alist);

        System.out.println("ArrayList element: " + alist.indexOf(2));
        alist.lastIndexOf(2);

        List<Integer> alist3 = alist.subList(1, 4);
        alist3.set(0, 100);
        System.out.println(alist3);

        System.out.println(alist);

    }
}