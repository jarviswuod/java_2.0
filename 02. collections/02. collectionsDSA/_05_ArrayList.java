/*

    NOTES:
     - We always want to code against the interface as it's a good practise
     - Wrapper classes are used to wrap primitive types into objects (Integer, Double, Character, etc.)
     - subList() -> Shallow copies the ArrayList, Meaning the origin array is affected when you make a change to the copied array

     - Creating an ArrayList:
         - new ArrayList<>() -> Using default way
         - new ArrayList<>(Collection c) -> Using Collections

     - ArrayList Methods:
         - add()
         - set()
         - addAll() -> Takes in any kind of collection
         - indexOf()
         - lastIndexOf()
         - subList()

 */

import java.util.ArrayList;
import java.util.List;

public class _05_ArrayList {

    public static void main(String[] args) {

        // add()
        List<Integer> alist = new ArrayList<>();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        System.out.println("After add(): " + alist); // [1, 2, 3]

        // set()
        System.out.println("Before set(): " + alist);
        int replaced = alist.set(1, 100);
        System.out.println("Element that was replaced = " + replaced);
        System.out.println("After set(): " + alist); // [1, 100, 3]

        // Constructor with collection
        List<Integer> alist2 = new ArrayList<>(alist);
        System.out.println("alist2 initialized from alist: " + alist2);

        // add()
        alist2.add(23);
        System.out.println("After add(23): " + alist2);

        // addAll()
        alist2.addAll(alist);
        System.out.println("After addAll(alist): " + alist2);

        // indexOf()
        int index = alist.indexOf(2); // should be -1 since 2 is replaced
        System.out.println("indexOf(2): " + index); // -1

        // lastIndexOf()
        int lastIndex = alist2.lastIndexOf(100);
        System.out.println("lastIndexOf(100): " + lastIndex);

        // subList()
        System.out.println("Original alist before subList: " + alist);
        List<Integer> alist3 = alist.subList(1, 3); // [100, 3]
        System.out.println("subList(1, 3): " + alist3);

        // set() in subList
        alist3.set(0, 200);
        System.out.println("After set(0, 200) in subList: " + alist3);
        System.out.println("alist affected by subList change: " + alist);
    }
}