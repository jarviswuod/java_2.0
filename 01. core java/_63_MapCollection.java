/*
 * Map is a collection of key and value pair
 * It's a collection of a Set and a List
 * 
 * 
 * .put() and .add()
 *  -> .add() - adds a new key & value
 *  -> .puts() - checks if the key is present then modifies or adds it afresh
 * 
 * 
 * HashMap and Hashtable
 * Hashtable is used in a synchronized version
 * HashMap is not
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class _63_MapCollection {

    public static void main(String[] args) {

        Map<String, Integer> students = new HashMap<>();

        students.put("Jarvis", 56);
        students.put("Navin", 23);
        students.put("Sushi", 67);
        students.put("Kian", 92);
        students.put("Harsh", 45);

        System.out.println(students.keySet());
        System.out.println();

        for (String key : students.keySet()) {
            System.out.println(key + " : " + students.get(key));
        }

    }
}
