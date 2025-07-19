/*
    NOTE:
      - A set is a collection of unique values
      - Set does not give value in a sorted format
      - Set does not have index value
      - Treeset sorts sets and can be replaced by Hashset

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