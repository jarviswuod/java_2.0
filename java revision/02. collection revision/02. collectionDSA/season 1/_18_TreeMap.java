/*

    NOTES:
    - TreeMap:
        - SortedMap:
            - SortedMap Interface methods:
                - firstKey() → smallest key in map (like first() in SortedSet)
                - lastKey() → largest key in map (like last() in SortedSet)

        - NavigableMap:
            - Navigable Interface methods:
                - First-last elements
                    - pollFirstEntry() → remove & return entry with smallest key (like pollFirst() in NavigableSet)
                    - pollLastEntry() → remove & return entry with largest key (like pollLast() in NavigableSet)
                    - firstEntry() → return entry with smallest key (no removal)
                    - lastEntry() → return entry with largest key (no removal)

                - Closest-Matches:
                    - ceilingEntry(key) → least entry with key >= given key (like ceiling() in NavigableSet)
                    - ceilingKey(key) → least key >= given key
                    - floorEntry(key) → greatest entry with key <= given key (like floor() in NavigableSet)
                    - floorKey(key) → greatest key <= given key
                    - higherEntry(key) → least entry with key > given key (like higher() in NavigableSet)
                    - higherKey(key) → least key > given key
                    - lowerEntry(key) → greatest entry with key < given key (like lower() in NavigableSet)
                    - lowerKey(key) → greatest key < given key

 */

public class _18_TreeMap {

}