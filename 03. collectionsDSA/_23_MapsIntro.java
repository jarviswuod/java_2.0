/*

    NOTES:
    - A map defined mappings from keys to values
    - The <key, value> pair called an entry
    - A map does not allow duplicate keys, in other words, the keys are unique
    - Both the keys and the values must be objects, with primitive values being wrapped in their respective wrappers objects when they are put in a map
    - A map is not a collection and the Map interface does not extend the Collection interface
    - However, the mappings can be viewed as a collection in various ways: a keySet, a value Collection or an entrySet


    Maps methods:
        - Object put(K key, V value)
        - Object get(Object key)
        - Object remove(Object key)
        - boolean containsKey(Object key)
        - boolean containsValue(Object key)
        - int size()
        - boolean isEmpty()


    Bulk operations:
        - void putAll(Map<? extends V> map)
        - void clear()
        - Set<K> keySet()
        - Collection<V> values()
        - Set<Map.Entry<K, V>> entrySet()


    Implementation of maps:
        - Order
            - Ordered maps:
                LinkedHashMap

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

public class _23_MapsIntro {

    public static void main(String[] args) {

    }
}