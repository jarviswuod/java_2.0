/*

    NOTES:

    Iterating Map
      - forEach
      - Removing an entry from the map
      - get only the keys
      - get only the values
      - different ways to iterate over the map
      - Enhanced for loop
      - Using iterator
      - Using java 8 stream
      - Using entrySet to iterate over key-value pairs

 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class _19_MapIteration {

    public static void main(String[] args) {

        Map<String, Integer> studentMarks = new HashMap<>();

        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 90);
        studentMarks.put("Charlie", 78);
        studentMarks.put("Diana", 92);

        // forEach
        studentMarks.forEach((name, marks) -> System.out.println(name + ": " + marks));

        // Removing an entry from the map
        studentMarks.remove("Charlie");
        System.out.println("After removing Charlie: " + studentMarks);

        // get only the keys
        Set<String> keys = studentMarks.keySet();
        System.out.println("Keys in the map: " + keys);

        // get only the values
        Collection<Integer> values = studentMarks.values();
        System.out.println("Values in the map: " + values);

        // different ways to iterate over the map
        System.out.println("Iterating over keys:");

        // Enhanced for loop
        for (String key : studentMarks.keySet()) {
            System.out.println(key + ": " + studentMarks.get(key));
        }

        // Using iterator
        System.out.println("Iterating using iterator:");
        for (Iterator<String> iterator = studentMarks.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            System.out.println(key + ": " + studentMarks.get(key));
        }

        // Using java 8 stream
        System.out.println("Iterating using Java 8 stream:");
        studentMarks.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("Iterating using Java 8 forEach:");
        studentMarks.forEach((key, value) -> System.out.println(key + ": " + value));

        // Using entrySet to iterate over key-value pairs
        System.out.println("Iterating using entrySet:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }
}
