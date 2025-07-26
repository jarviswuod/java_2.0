import java.util.NavigableMap;
import java.util.TreeMap;

public class _26_TreeMapMethods {

    public static void main(String[] args) {

        NavigableMap<Integer, String> treeMap1 = new TreeMap<>((a, b) -> b - a);

        NavigableMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Jarvis");
        treeMap.put(2, "Wuod");
        treeMap.put(3, "Sherlene");
        treeMap.put(4, "Lean");

        System.out.println(treeMap);
        System.out.println();

        treeMap.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println();
        System.out.println();

        System.out.println(treeMap.pollFirstEntry()); // 1=Jarvis
        System.out.println(treeMap.pollLastEntry()); // 4=Lean

        System.out.println(treeMap.ceilingKey(3)); // 3
        System.out.println(treeMap.ceilingEntry(1).getValue()); // Wuod
        System.out.println(treeMap.ceilingEntry(2).getKey()); // 2

        System.out.println("treeMap1: " + treeMap1);
    }
}
