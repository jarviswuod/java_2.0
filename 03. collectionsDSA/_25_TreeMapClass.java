import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class _25_TreeMapClass {

    public static void main(String[] args) {

        NavigableMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Jarvis");
        treeMap.put(2, "Wuod");
        treeMap.put(3, "Sherlene");
        treeMap.put(4, "Lean");
        treeMap.put(5, "Matt");
        treeMap.put(6, "Greg");
        treeMap.remove(4);

        System.out.println(treeMap);
        System.out.println();

        // Using entrySet to traverse the map
        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();
        // for (Map.Entry< Integer,String> entry : map.entrySet()) {
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();
        System.out.println();

        // map.keySet() to get all keys
        Set<Integer> keys = treeMap.keySet();
        for (Integer key : keys) {
            System.out.println(key + ": " + treeMap.get(key));
        }

        System.out.println();
        System.out.println();

        // Using for-each loop to traverse the map
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();
        System.out.println();

        // Using lambda expression to traverse the map
        treeMap.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
