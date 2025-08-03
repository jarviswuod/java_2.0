/*

    NOTES:
    - Map must always be defined in key, value pair
    - Map methods:
        - get() -> retrives values from a map but not safe for chaining
        - getOrDefault() -> Solves the exception that arises by seeking a non existing key in a map
        - containsKey() -> Returns a boolean based on a condition if a key is present or not
        - remove() -> For deleting keyvalue pair based on a pair
        - computeIfAbsent() -> Takes in 2 parameters, a key and a lambda that executes if key doesnot exist

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _24_Maps {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        // Accessing a value by key
        System.out.println("Alice's age: " + map.get("Alice"));

        // safe get method
        System.out.println("David's age: " + map.getOrDefault("David", -1)); // returns -1 if key "David" does not exist

        // Checking if a key exists
        System.out.println("Contains key 'Bob'? " + map.containsKey("Bob"));

        // Removing an entry
        map.remove("Charlie");
        System.out.println("After removing Charlie: " + map);

        Map<Integer, List<Integer>> mapListing = new HashMap<>();
        mapListing.put(1, List.of(10, 20, 30));
        mapListing.put(2, List.of(40, 50));
        mapListing.put(3, List.of(60, 70, 80, 90));

        // safe add value to nested map
        mapListing.computeIfAbsent(4, k -> List.of(100, 110));
        System.out.println("Nested Map: " + mapListing);

        Map<Integer, List<Integer>> listMap = new HashMap<>();
        if (listMap.get(1) == null)
            listMap.put(1, new ArrayList<>());
        listMap.get(1).add(10);
        listMap.get(1).add(20);
        listMap.get(1).add(30);

        System.out.println("Another Nested Map: " + listMap);

        // Alternatively, you can use computeIfAbsent
        listMap.computeIfAbsent(2, k -> new ArrayList<>()).add(40);
        listMap.computeIfAbsent(2, k -> new ArrayList<>()).add(50);
        listMap.computeIfAbsent(3, k -> new ArrayList<>()).add(60);
        listMap.computeIfAbsent(3, k -> new ArrayList<>()).add(70);
        listMap.computeIfAbsent(3, k -> new ArrayList<>()).add(80);
        listMap.computeIfAbsent(3, k -> new ArrayList<>()).add(90);

        System.out.println("Another Nested Map after computeIfAbsent: " + listMap);

    }
}