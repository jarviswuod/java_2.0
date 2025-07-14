/*
 * Collections
 * -------------------------------
 * Collections API -> Concept
 * Collection -> interface
 * Collections -> class
 * 
 * 
 * Collection
 * -> List --> ArrayList, LinkedList
 * -> Queue --> Dequeue
 * -> Set --> Hashset, LinkedHashSet
 * -> Map --> Hashtable, HashMap
 * 
 */

/*
 * By default collection sreceive object types (not integers, not String) Hence
 * -> You hace to explicitly use <Integer> object when initiating the collection
 *     --> 1. To prevent errors (Syntax)
 *     --> 2.  Iteration down the line
 * 
 */

import java.util.ArrayList;
import java.util.Collection;

public class _60_Collections {

    public static void main(String[] args) {

        Collection<Integer> nums = new ArrayList<>();

        nums.add(6);
        nums.add(9);
        nums.add(5);
        nums.add(8);
        nums.add(2);
        // nums.add("5"); // Collection<Integer> is not applicable for (String)

        // for (Object integer : nums) {
        for (Integer integer : nums) {
            System.out.println(integer);
        }
    }
}