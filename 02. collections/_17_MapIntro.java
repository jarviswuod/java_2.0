/*

    NOTES:
    Map
      - Java HashMap is a hashtable based implementation of the Map interface
      - A HashMap  cannot contain duplicate keys
      - Java HashMap allows null values and one null key
      - Java HashMap is an unordered collection
      - Java HashMap is not thread-safe. You must explicitly synchronize concurrent modifications to the HashMap

 */

import java.util.HashMap;
import java.util.Map;

public class _17_MapIntro {

    public static void main(String[] args) {

        // Using default HashMap constructor
        Map<String, Integer> studentMarks = new HashMap<>();

        // Adding key-value pairs to the map
        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 90);
        studentMarks.put("Charlie", 78);
        studentMarks.put("Diana", 92);

        // Adding a null key with a value
        studentMarks.put(null, 74);
        studentMarks.put(null, 66); // This will overwrite the previous null key value

        System.out.println("Student Marks: " + studentMarks);

    }
}