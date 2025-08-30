/*

    NOTES:
    - Map:
        - HashMap;;; Unordered Map
        - LinkedHashMap;;; keeps insertion order, not sorted
        - TreeMap <- NavigableMap <- SortedMap;;; auto-sorted

    - LinkedHashMap:
        - Faster than TreeMap but slower than Hashmap
        - Combines both LinkedList and HashMap
        - Maintains insertion order

    - Vital rule
        - Code against the interface, not the concrete class

    - Map Features:
        - No duplicate allowed
        - Only one single'null' element
        - No single insertion order maintained

    - Utility methods
        - putAll(Collection c)
        - removeAll(Collection c)
        - retainAll(Collection c)
        - containsAll(Collection c)

    - Map Methods:
        - put(key, value)
        - remove(key)
        - containsKey(key)
        - containsValue(value)
        - entrySet()
            - getKey()
            - getValue()
        - keySet()
        - values()
        - isEmpty()
        - clear()
        - size()

    - Sorted methods
        - firstKey()
        - lastKey()

    - Navigable methods
        - pollFirstEntry()
        - pollLastEntry()
        - firstEntry()
        - lastEntry()

    - TreeMap methods: sorted Map
        - ceilingEntry()
        - ceilingKey()
        - floorEntry()
        - floorKey()
        - higherEntry()
        - higherKey()
        - lowerEntry()
        - lowerKey()

    - Iterator Methods:
        - next()
        - hasNext()
        - remove()

    - Sorting Map: convert to List collection first
        - comparable; natural ordering: compare(arg0)
        - comparator; total ordering: compareTo(arg0, arg1)

        - Collections.sort(Collection c)
        - Collections.sort(Collection c, (a, b) -> a - b);
        - Collections.reverse()

    - Looping through Maps:
        - Iterator for loop
        - Iterator while loop
        - Enhanced for loop
        - forEach loop
        - stream.forEach

 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class _05_Maps {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Jarvis");
        map.put(2, "Wuod");
        map.put(3, "Steven");
        map.put(4, "Majimbo");

        map.remove(3);
        map.containsKey(1);
        map.containsValue("wuod");
        Set<Map.Entry<Integer, String>> mapEntry = map.entrySet();
        for (Entry<Integer, String> entry : mapEntry) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        Set<Integer> mapSet = map.keySet();
        Collection<String> mapvals = map.values();

        System.out.println("KeySet method : " + mapSet);
        for (int entry : map.keySet()) {
            System.out.println(entry + "- " + map.get(entry));
        }
        System.out.println();

        System.out.println("Values : " + mapvals);
        System.out.println("Is empty : " + map.isEmpty());
        map.forEach((key, value) -> System.out.println(key + "* " + value));
        map.clear();
        System.out.println(map.size());
    }
}