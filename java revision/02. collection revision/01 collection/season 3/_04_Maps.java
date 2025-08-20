/*

    NOTES:
    - Map Types:
        - HashMap
        - Hashtable
        - TreeMap

    - Map Creation
        - default constructor -> Map<key, value> map = HashMap<>();
        - Parametized way -> Map<key, value> map = HashMap<>(Collection c);
        - putAll() -> list1.putAll(Collection c)

    - Map features:
        - Key-value pair
        - one null key
        - no duplicate key
        - insertion order

    - Map methods:
        - size()
        - put(key, value)
        - remove(key)
        - get(key)
        - clear()
        - isEmpty()
        - containsKey(key)
        - containsValue(value)
        - keySet()
        - values()
        - putAll(Collection c)
        - removeAll(Collection c)
        - retainAll(Collection c)
        - containsAll(Collection c)

    - Iterating over set
        - Enhanced for loop
        - forEach loop
            for (String key : studentMarks.keySet()) {
                System.out.println(key + ": " + studentMarks.get(key));
            }
        - stream.forEach
        - while loop Iterator
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        - for loop Iterator
            for (Iterator<String> iterator = studentMarks.keySet().iterator(); iterator.hasNext();) {
                String key = iterator.next();
                System.out.println(key + ": " + studentMarks.get(key));
            }
 */

public class _04_Maps {

}
