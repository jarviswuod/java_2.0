import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _22_MapsCreationAndMethods {

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

        Map<Integer, List<Integer>> nestedMap = new HashMap<>();
        nestedMap.put(1, List.of(10, 20, 30));
        nestedMap.put(2, List.of(40, 50));
        nestedMap.put(3, List.of(60, 70, 80, 90));

        // safe add value to nested map
        nestedMap.computeIfAbsent(4, k -> List.of(100, 110));
        System.out.println("Nested Map: " + nestedMap);

        Map<Integer, List<Integer>> anotherNestedMap = new HashMap<>();
        if (anotherNestedMap.get(1) == null)
            anotherNestedMap.put(1, new ArrayList<>());
        anotherNestedMap.get(1).add(10);
        anotherNestedMap.get(1).add(20);
        anotherNestedMap.get(1).add(30);

        System.out.println("Another Nested Map: " + anotherNestedMap);

        // Alternatively, you can use computeIfAbsent
        anotherNestedMap.computeIfAbsent(2, k -> new ArrayList<>()).add(40);
        anotherNestedMap.computeIfAbsent(2, k -> new ArrayList<>()).add(50);
        anotherNestedMap.computeIfAbsent(3, k -> new ArrayList<>()).add(60);
        anotherNestedMap.computeIfAbsent(3, k -> new ArrayList<>()).add(70);
        anotherNestedMap.computeIfAbsent(3, k -> new ArrayList<>()).add(80);
        anotherNestedMap.computeIfAbsent(3, k -> new ArrayList<>()).add(90);

        System.out.println("Another Nested Map after computeIfAbsent: " + anotherNestedMap);

    }
}
