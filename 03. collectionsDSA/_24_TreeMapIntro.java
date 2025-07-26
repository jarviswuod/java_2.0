/*
    SortedMap NOTES :
     - The SortedMap and NavigableMap interfaces are the analogs of the SortedSet and the NavigableSet interfaces, respectively.
     - The SortedMap interface extends the Map interface to provide the fucntionality for implementing maps with sorted keys. It's operations are analogous to those of teh SortedSet interface
     - SortedMap Interfce Methods:
         - K firstKey() Sorted set:first()
         - K lastKey() Sorted set:last()

         
    NavigableMap NOTES :
     - NavigableMap interface extends the SOrtedMap interface with navigation methods to find the closest matched for specific search targets
     - In addition to the methods of teh SortedMap interface, the Navigable interface adds the new methods, analogous to the NavigableSet interface.

        First-last elements
             - Map.Entry<K,V> pollFirstEntry() Navigable set: pollFirst()
             - Map.Entry<K,V> pollLastEntry() Navigable set: pollLast()
             - Map.Entry<K,V> firstEntry()
             - Map.Entry<K,V> lastEntry()
        
        
        Closest-Mathches:
             - Map.Entry<K,V> ceilingEntry() Navigable set: ceiling()
             - K ceilingKey(K key)
             - Map.Entry<K,V> floorEntry() Navigable set: floor()
             - K floorKey(K key)
             - Map.Entry<K,V> higherEntry() Navigable set: higher()
             - K higherKey(K key)
             - Map.Entry<K,V> lowerEntry() Navigable set: lower()
             - K lowerKey(K key)
        

    TreeMap NOTES :
     - The TreeMap class implements the NavigableMap interface, and thereby the SortedMap interface
     - By default, operations on sorted maps rely on the natural ordering of the keys
     - However, a total ordering can be specified by passing a customized comaprator to the constructor
     - The TreeMap implmentation uses balanced trees, which develiver excellent perforance for all operations
     - Howerver, searching in HasMap can be faster than in a TreeMap, as hashing algorithms usually offer better performance than the search algorithms for balanced trees

 */

public class _24_TreeMapIntro {
    public static void main(String[] args) {

    }
}
