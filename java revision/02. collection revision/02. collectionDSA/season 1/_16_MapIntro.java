/*

    NOTES:
    - Map:
        - Is a defined mappings from keys to values
        - The <key, value> pair called an entry
        - A map does not allow duplicate keys, in other words, the keys are unique
        - Both the keys and the values must be objects, with primitive values being wrapped in their respective wrappers objects when they are put in a map
        - A map is not a collection and the Map interface does not extend the Collection interface, however, the mappings can be viewed as a collection in various ways:
            - a keySet
            - a value Collection
            - an entrySet


    - Map methods:
        - put(key, value)
        - get(key)
        - remove(key)
        - containsKey(key)
        - containsValue(value)
        - size()
        - isEmpty()
        - computeIfAbsent() -> Takes in 2 parameters, a key and a lambda that executes if key doesnot exist


    - Bulk operations:
        - putAll(Map<? extends V> map)
        - clear()
        - keySet() -> Set<K>
        - values() -> Collection<V>
        - entrySet() -> Set<Map.Entry<K, V>>


    - Implementation of Map:
        - Order
            - Ordered maps:
                - LinkedHashMap

            - Unordered maps:
                - HashMap
                - Hashtable

        - Sort
            - TreeMap

        - HashMap class
            - NOT thread-safe
            - Permits one null key

        - Hashtable class
            - Thread-safe
            - Permits non-null keys

 */

public class _16_MapIntro {

}