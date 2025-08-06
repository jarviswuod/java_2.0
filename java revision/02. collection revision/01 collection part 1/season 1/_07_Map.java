/*
 Map
 HashMap
 TreeMap
 Hashtable

    put(key, value)
    putAll(Collection c)
    remove(key)
    removeAll(Collection c)
    containsKey(key)
    containsValue(value)
    get(key)
    

    - keySet() -> key
    - values() -> values

    Looping

    - forEach

    - entrySet()
      - getKey()
      - getValue()


    keySet().iterator();    hasNext();
    - next()
    - get()


    - keySet()
    - get()


 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class _07_Map {

    public static void main(String[] args) {

        Map<String, Integer> marks = new HashMap<>();
        marks.put("Jarvis", 98);
        marks.put("Wuod", 88);
        marks.put("Nairobi", 42);
        marks.put("Tokyo", 43);
        marks.put("Jack", 72);
        System.out.println(marks);

        marks.remove("Jarvis");
        System.out.println(marks);

        marks.put("Jarvis", 98);
        System.out.println(marks.get("Jarvis"));
        System.out.println(marks);
        System.out.println(marks.containsKey("Jarvis"));
        System.out.println(marks.containsValue(42));

        System.out.println("---- LOOPING ----");
        System.out.println("keySet()");
        Set<String> set = marks.keySet();
        System.out.println(set);

        System.out.println("values()");
        Collection<Integer> values = marks.values();
        System.out.println(values);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("---- Iterator ----");
        System.out.println("FOR EACH");
        marks.forEach((key, value) -> System.out.print(key + " " + value + ",  "));
        System.out.println();

        // Using entrySet to iterate over key-value pairs
        System.out.println("Iterating using entrySet:");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }
        System.out.println();

        // Using iterator
        System.out.println("Iterating using iterator:");
        for (Iterator<String> iterator = marks.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            System.out.println(key + ": " + marks.get(key));
        }
        System.out.println();

        // Enhanced for loop
        System.out.println("Iterating using iterator:");
        for (String key : marks.keySet()) {
            System.out.println(key + ": " + marks.get(key));
        }
        System.out.println();
    }
}
