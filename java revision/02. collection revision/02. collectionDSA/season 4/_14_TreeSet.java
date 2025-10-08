/*

    NOTES:
    - Sorted Methods:
        - first()
        - last()
        - headSet(element)
        - tailSet(element)
        - subSet(el, el)


    - Navigable Methods:
        - pollFirst()
        - pollLast()
        - descendingSet()
        - descendingIterator()


    - TreeSet Methods:
        - higher(element)
        - lower(element)
        - ceiling(element)
        - floor(element)

 */

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _14_TreeSet {
    public static void main(String[] args) {

        Set<Integer> marks = new HashSet<>();
        marks.add(43);
        marks.add(44);
        marks.add(53);
        marks.add(90);
        marks.add(67);

        TreeSet<Integer> treeSet = new TreeSet<>(marks);
        System.out.println(treeSet);

        // System.out.println("-----INIT-----");
        // System.out.println("pollFirst: " + treeSet.pollFirst());
        // System.out.println("pollLast: " + treeSet.pollLast());

        System.out.println("-----INIT-----");
        System.out.println("higher: " + treeSet.higher(43));
        System.out.println("lower: " + treeSet.lower(67));

        System.out.println("-----INIT-----");
        System.out.println("ceiling: " + treeSet.ceiling(43));
        System.out.println("floor: " + treeSet.floor(67));

        System.out.println();
        System.out.println(treeSet);

        System.out.println("-----ANOTHER SET-----");
        System.out.println("first: " + treeSet.first());
        System.out.println("last: " + treeSet.last());

        System.out.println();
        System.out.println();
        System.out.println(treeSet);

        System.out.println("-----       -----");
        System.out.println("headSet: " + treeSet.headSet(67));
        System.out.println("tailSet: " + treeSet.tailSet(67));
        System.out.println("subSet: " + treeSet.subSet(43, 67));

    }

}
