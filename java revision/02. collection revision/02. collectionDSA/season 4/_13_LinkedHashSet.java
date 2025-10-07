/*

    NOTES:
    - Intro
        - Is a combination of both ArrayList and HashSet
        - It's faster than a TreeSet but slower than a HashSet
        - It stored elements follwing the elements insertion order

 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class _13_LinkedHashSet {
    public static void main(String[] args) {

        LinkedHashSet<Integer> listHash = new LinkedHashSet<>();
        Set<Integer> list = new HashSet<>();

        listHash.add(43);
        listHash.add(44);
        listHash.add(53);
        listHash.add(90);
        listHash.add(67);

        list.add(43);
        list.add(44);
        list.add(53);
        list.add(90);
        list.add(67);

        System.out.println("list : " + list);
        System.out.println("linkedHashSet : " + listHash);
    }
}
