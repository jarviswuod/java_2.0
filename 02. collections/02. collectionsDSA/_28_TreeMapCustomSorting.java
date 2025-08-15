import java.util.NavigableMap;
import java.util.TreeMap;

public class _28_TreeMapCustomSorting {

    public static void main(String[] args) {

        NavigableMap<Integer, String> treeMap1 = new TreeMap<>((a, b) -> b - a);

        NavigableMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(11, "Jarvis");
        treeMap.put(42, "Lean");
        treeMap.put(25, "Wuod");
        treeMap.put(38, "Sherlene");

        System.out.println(treeMap);

        treeMap.forEach((key, value) -> System.out.print(key + ": " + value + ",   "));
        System.out.println();

        System.out.println(treeMap.pollFirstEntry()); // 11 = Jarvis
        System.out.println(treeMap.pollLastEntry()); // 42 = Lean

        System.out.println(treeMap.ceilingKey(33)); // 38
        System.out.println(treeMap.ceilingEntry(11).getValue()); // Wuod
        System.out.println(treeMap.ceilingEntry(22).getKey()); // 25

        System.out.println("custom treeMap: " + treeMap1); // custom treeMap: {}
    }
}