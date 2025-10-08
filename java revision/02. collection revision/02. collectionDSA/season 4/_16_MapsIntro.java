/*

    NOTES:
    - put() inplace of add()
    - key, value pair data storage
    - no duplicate keys, else we update the value pair



    - Hashtable:
        - Thread safe
        - No null keys allowed


    - HashMap:
        - only one null
        - not thread safe

    - LinkedHashMap:
        - 

    - Sorted Map:
        - Navigable Map:
            - Tree Map:
                - pollFirstEntry()
                - pollLastEntry()

                - firstEntry()    - > firstKey()
                - lastEntry()     - > lastKey()
                - ceilingEntry()  - > ceilingKey()
                - floorEntry()    - > floorKey()
                - higherEntry()   - > higherKey()
                - lowerEntry()    - > lowerKey()


 */

import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class _16_MapsIntro {
    public static void main(String[] args) {

        TreeMap<String, Integer> age = new TreeMap<>();
        age.put("Jarvis", 22);
        age.put("Packs", 25);
        age.put("Ramsey", 34);
        age.put("Vans", 20);
        age.put("Janis", 56);
        age.put("Wuod", 32);

        Set<Entry<String, Integer>> keys = age.entrySet();

        for (Entry<String, Integer> string : keys) {
            System.out.println(string);
        }

        System.out.println("AGE : " + age);
        System.out.println();

        System.out.println("firstEntry : " + age.firstEntry());
        System.out.println("lastEntry : " + age.lastEntry());

        System.out.println("firstKey : " + age.firstKey());
        System.out.println("lastKey : " + age.lastKey());

        System.out.println();
        System.out.println("AGE : " + age);
        System.out.println();

        System.out.println("ceilingEntry : " + age.ceilingEntry("Vans"));
        System.out.println("floorEntry : " + age.floorEntry("Vans"));

        System.out.println("ceilingKey : " + age.ceilingKey("Vans"));
        System.out.println("floorKey : " + age.floorKey("Vans"));

        System.out.println();
        System.out.println("AGE : " + age);
        System.out.println();

        System.out.println("higherEntry : " + age.higherEntry("Vans"));
        System.out.println("lowerEntry : " + age.lowerEntry("Vans"));

        System.out.println("higherKey : " + age.higherKey("Vans"));
        System.out.println("lowerKey : " + age.lowerKey("Vans"));

    }
}
