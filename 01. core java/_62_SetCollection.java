/*

    NOTES:
      - A set is a collection of unique values (Does not allow duplicates or muliple null values)
      - Set does not give value in a sorted format
      - Set does not have index value
      - Treeset does sorting of sets values and can be used in place of Hashset

    SET METHODS:
      - add()
      - remove()
      - addAll()
      - removeAll()
      - clear()
      - contains()
      - containsAll()
      - retainAll()
      - isEmpty()
      - size()
      - iterator()
      - toArray()

 */

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _62_SetCollection {
    public static void main(String[] args) {
        Set<Integer> numsHash = new HashSet<Integer>();
        Set<Integer> numsTree = new TreeSet<Integer>();

        numsHash.add(62);
        numsHash.add(54);
        numsHash.add(82);
        numsHash.add(21);
        numsHash.add(16);

        numsTree.add(62);
        numsTree.add(54);
        numsTree.add(82);
        numsTree.add(21);
        numsTree.add(16);

        for (Integer integer : numsHash) {
            System.out.println(integer);
        }

        System.out.println();

        for (Integer integer : numsTree) {
            System.out.println(integer);
        }
    }
}