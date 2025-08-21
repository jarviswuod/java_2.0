/*

    NOTES:
    - Features/properties:
        - No duplicates keys
        - No insertion order maintained
        - No indexing


    - Methods:
        - Map:
            - put(key, value)
            - isEmpty()
            - size()
            - remove(element)
            - containsKey(key)
            - containsValue(value)
            - keySet()
            - entrySet()
            - containsAll()
            - removeAll()
            - retainAll()
            - putAll()
            - clear()

            - get(key)
            - getOrDefault(key, -1)
            - computeIfAbsent()

        - SortedMap ops: 
            - first()
            - last()
            - headMap()
            - tailMap()
            - subMap()

        - NavigableMap extras: 
            - pollFirst()
            - pollLast()
            - descendingMap()
            - descendingIterator()

        - TreeMap:
            - ceiling() → least element >= given value
            - floor() → greatest element <= given value
            - higher() → least element > given value
            - lower() → greatest element < given value


    - Types:
        - HashMap<key, value>
        - Hashtable<key, value>
        - LinkedHashMap<key, value>
            - Insertion order
            - implement both LinkedList and HashMap
            - slower than HashMap but faster than Treemap

        - TreeMap<key, value> <- Navigable interface <- Sorted Interface


    - Creating Map:
        - default constructor; new HashMap<>();
        - parametized constructor; new HashMap<>(Collection c);
        - put all method; list.putAll(Collection c);


    - Custom HashMap
        - Always override equals() and hashcode() of your custom class before using it in a HashMap

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _09_Maps {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> mapListing = new HashMap<>();
        mapListing.put(1, List.of(10, 20, 30));

        mapListing.computeIfAbsent(4, k -> List.of(100, 110));

        Map<Integer, List<Integer>> listMap = new HashMap<>();

        listMap.computeIfAbsent(2, k -> new ArrayList<>()).add(40);
        listMap.computeIfAbsent(2, k -> new ArrayList<>()).add(50);
        listMap.computeIfAbsent(3, k -> new ArrayList<>()).add(60);
    }
}