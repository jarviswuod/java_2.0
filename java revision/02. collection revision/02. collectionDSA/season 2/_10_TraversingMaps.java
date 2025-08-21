import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _10_TraversingMaps {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        // Using entrySet to traverse the map
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        // for (Map.Entry<String, Integer> entry : map.entrySet()) {
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry.getKey() + ": " + entry.getValue() + ",   ");
        }

        System.out.println();

        // map.keySet() to get all keys
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.print(key + ": " + map.get(key) + ",   ");
        }

        System.out.println();

        // Using lambda expression to traverse the map
        map.forEach((key, value) -> System.out.print(key + ": " + value + ",   "));
        System.out.println();
    }

}
