/*

    NOTES:
    - A map defined mappings from keys to values
    - The <key, value> pair called an entry
    - A map does not allow duplicate keys, in other words, the keys are unique
    - Both the keys and the values must be objects, with primitive values being wrapped in their respective wrappers objects when they are put in a map
    - A map is not a collection and the Map intetface does not extend the Collection interface
    - Howerver, the mappings can be viewd as a collection in various ways: a key set, a value collection or an entry set


    MAP INTERFACE METHODS:
        - Object put(K key, V value)
        - Object get(Object key)
        - Object remove(Object key)
        - boolean containsKey(Object key)
        - boolean containsValue(Object key)
        - int size()
        - boolean isEmpty()


    BULk OPERATIONS:
        - void putAll(Map<? extends V> map)
        - void clear()
        - Set<K> keySet()
        - Collection<V> values()
        - Set<Map.Entry<K, V>> entrySet()


    BULK OPERATION BREAKDOWN:
        interface Entry<K, V>{
            K getKey();
            V getValue();
            V setValue(V value);
        }

        - Each <key, value> in the entry set view is represented by an object implementing the nested Map
        - A entry in the entry set view can be manipulated by methods defined in this interface


    IMPLEMENTATION OF MAPS:
        - The classes HashMap and Hastable implment the unordered maps. The class LinkedHashMap implments ordered maps
        - The class TreeMap implements sorted maps
        - While the HashMap class is not thread-safe and permits one null key, the Hashtable class is thread-safe and permits non-null keys and values only
        - The thread-safety provided by the Hashtable class comes with a perfomance penatly
        - Both the HashMap and the LikedHashMap classes provide comparable perfornamce, but the HashMap class is the natural choice if ordering is not an issue
        - OPeration such as adding, removing, or finding an entry based on a key are in constant time, as these hash the key
        - Operations such as finding the entry with a particular value are in linear time, as these involve searching through the entries
        - Adding, removing, finding entries in a LinkedHashMap can be slightly slower than in a HashMap, as an ordered double-linked list had to be maintained
        - Traversal of a map is through one of its collectino-views. For an underlying LinkedHashMap, the traversal time it proportional to the size of the map-regardless of its capacity

 */

public class _23_MapsIntro {

    public static void main(String[] args) {

    }
}