/*

    NOTES:

    Map Methods
      - put() -> Adding key-value pairs to the map
      - isEmpty() -> Checking if the map is empty
      - size() -> Checking the size of the map
      - get() -> Accessing a value using its key
      - containsKey() -> Checking if a key exists
      - containsValue() -> Checking if a value exists
      - remove() -> Removing an entry from the map
      - keySet() -> get only the keys
      - values() -> get only the values

 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _18_MapMethods {

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

    }
}
