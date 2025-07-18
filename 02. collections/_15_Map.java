/*
 * 
 * Map KeyPoints
 * -> Java HashMap is a hashtable based implementation of the Map interface.
 * -> A HashMap  cannot contain duplicate keys.
 * -> Java HashMap allows null values and one null key.
 * -> Java HashMap is an unordered collection.
 * Java HashMap is not thread-safe. You must explicitly synchronize concurrent modifications to the HashMap.
 * 
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class _15_Map {

    public static void main(String[] args) {

        // Creating a Map using HashMap
        Map<String, Integer> studentMarks = new HashMap<>();

        // Adding key-value pairs to the map
        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 90);
        studentMarks.put("Charlie", 78);
        studentMarks.put("Diana", 92);

        // Adding a null key with a value
        studentMarks.put(null, 74);
        studentMarks.put(null, 66); // This will overwrite the previous null key value

        // Displaying the map
        System.out.println("Student Marks: " + studentMarks);

        // Checking if the map is empty
        System.out.println("Is the map empty? " + studentMarks.isEmpty());

        // Checking the size of the map
        System.out.println("Total Students: " + studentMarks.size());

        // Accessing a value using its key
        System.out.println("Marks of Bob: " + studentMarks.get("Bob"));

        // Checking if a key exists
        System.out.println("Does Alice exist? " + studentMarks.containsKey("Alice"));

        // Checking if a value exists
        System.out.println("Does anyone have 90 marks? " + studentMarks.containsValue(90));

        // Iterating over the map using forEach
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

        // using iterator
        System.out.println("Iterating using iterator:");
        for (Iterator<String> iterator = studentMarks.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            System.out.println(key + ": " + studentMarks.get(key));
        }

        // using java 8 stream
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
