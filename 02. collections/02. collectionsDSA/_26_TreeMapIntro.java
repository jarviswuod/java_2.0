/*

    NOTES
    - SortedMap:
        - SortedMap Interface methods:
            - K firstKey() Sorted set:first()
            - K lastKey() Sorted set:last()

    - NavigableMap:
        - Navigable Interface methods:
            - First-last elements
                - Map.Entry<K,V> pollFirstEntry() Navigable set: pollFirst()
                - Map.Entry<K,V> pollLastEntry() Navigable set: pollLast()
                - Map.Entry<K,V> firstEntry()
                - Map.Entry<K,V> lastEntry()

            - Closest-Matches:
                - Map.Entry<K,V> ceilingEntry() Navigable set: ceiling()
                - K ceilingKey(K key)
                - Map.Entry<K,V> floorEntry() Navigable set: floor()
                - K floorKey(K key)
                - Map.Entry<K,V> higherEntry() Navigable set: higher()
                - K higherKey(K key)
                - Map.Entry<K,V> lowerEntry() Navigable set: lower()
                - K lowerKey(K key)


    - TreeMap:
        - By default, operations on sorted maps rely on the natural ordering of the keys
        - A total ordering however can be specified by passing a customized comparator to the constructor
        - Searching in HashMap can be faster than in a TreeMap

 */

public class _26_TreeMapIntro {
}