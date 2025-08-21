/*

    NOTES:
    - First Part


        - TreeMap methods:
            - getOrDefault(key, -1)
            - containsKey(key)
            - computeIfAbsent(key, k -> new ArrayList<>()).add(40)
            
            - firstKey()
            - lastKey()
            - pollFirstEntry()
            - pollLastEntry()
            - firstEntry()
            - lastEntry()
            - ceilingEntry()
            - floorEntry()
            - higherEntry()
            - lowerEntry()

            - ceilingEntry(dgts).getValue()
            - ceilingEntry(dgts).getKey()


        - TreeSet methods:
            - ceiling()
            - floor()
            - higher()
            - lower()

        - Navigable & sorted methods:
            - first()
            - last()
            - headSet()
            - tailSet()
            - descendingSet()
            - descendingIterator()

    - Another Part:
        - keySet()
        - entrySet()
            - getKey()
            - getValue()

        - containsKey(key)
        - containsValue(value)

 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _11_MapsAgain {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Jarvis");
        map.put(2, "Wuod");
        map.put(3, "Another");
        map.put(4, "Randomz");

        Set<Integer> keys = map.keySet();

        // for (Integer key : map.keySet()) {
        for (Integer key : keys) {
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println();

        Collection<String> names = map.values();
        System.out.println(names);
        System.out.println();

        Set<Map.Entry<Integer, String>> mapSet = map.entrySet();

        for (Map.Entry<Integer, String> entry : mapSet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();

        System.out.println(mapSet);

    }
}