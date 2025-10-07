/*

    NOTES:
    - 3 Creating a HashSet
        - using default constructor
        - using parametized constructor
        - using addAll()


    - Looping through HashSet
        - Enhanced for loop
        - for loop iterator
        - while loop iterator
        - forEach
        - stream forEach


    - HashSet Methods:
        - contains()
        - get()
        - add()
        - remove()
        - size()
        - isEmpty()

 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _11_HashSet {
    public static void main(String[] args) {

        Set<Integer> marks = new HashSet<>();
        marks.add(43);
        marks.add(44);
        marks.add(53);
        marks.add(90);
        marks.add(67);

        System.out.println("marks :" + marks);
        System.out.println("size :" + marks.size());
        System.out.println("isEmpty :" + marks.isEmpty());
        System.out.println("contains :" + marks.contains(32));
        System.out.println("contains :" + marks.contains(67));

        System.out.println();

        Iterator<Integer> iter = marks.iterator();

        for (; iter.hasNext();) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        System.out.println("----- WHILE----");

        Iterator<Integer> iterMarks = marks.iterator();

        while (iterMarks.hasNext()) {
            System.out.print(iterMarks.next() + " ");
        }
        System.out.println();
    }
}
