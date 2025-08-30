/*

    NOTES:
    - Maps methods:
        - put(key, value)
        - putAll(Collection map)
        - remove(key)
        - removeAll(Collection map)
        - keySet()
        - get(key)
        - entrySet()
            - getKey()
            - getValue()
        
        - containsKey(key)
        - containsValue(value)
        - isEmpty()

 */

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;

public class _05_Map {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Jarvis");
        map.put(2, "Random");
        map.put(3, "Keynote");
        map.put(4, "Wuod");

        // System.out.println(map.keySet());
        // System.out.println(map.values());
        System.out.println(map.get(4));
        System.out.println(map.containsKey(5));
        System.out.println(map.containsValue("map"));
        // System.out.println(map.entrySet());

        Set<Integer> keys = map.keySet();
        System.out.println(keys);
        for (Integer key : keys) {
            System.out.print(map.get(key) + ",  ");
        }
        System.out.println();

        Collection<String> vals = map.values();
        System.out.println(vals);
        System.out.println();

        Set<Map.Entry<Integer, String>> keyEntries = map.entrySet();
        for (Entry<Integer, String> entry : keyEntries) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        System.out.println();

        map.forEach((key, value) -> System.out.println(key + "* " + value));

    }
}
