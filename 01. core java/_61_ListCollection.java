/*
 * You can replace the collection with List. 
 * -> Reason? List has lots of other methods at disposal
 * 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class _61_ListCollection {

    public static void main(String[] args) {

        Collection<Integer> numsCollection = new ArrayList<Integer>();
        List<Integer> numsList = new ArrayList<Integer>();

        numsCollection.add(6);

        System.out.println(numsCollection.size());

        numsList.add(6);
        numsList.add(9);
        numsList.add(8);

        System.out.println(numsList.indexOf(5));
        System.out.println(numsList.get(2));

    }
}