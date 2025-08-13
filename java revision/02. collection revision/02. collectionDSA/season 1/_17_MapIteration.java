/*

    NOTES:
    - MapIteration:
        - Map is not a collection meaning it's not iterable.
        - To traverse through a map we need to first convert it into a set because of it's unique key's
            - entrySet()
            - keySet()

        - KEY:
            - entrySet()
                - getKey()
                - getValue()

            - keySet()
                - get(key)

                
            EXAMPLE 1

             Set<Map.Entry<String, Integer>> entries = map.entrySet();

            // for (Map.Entry<String, Integer> entry : map.entrySet()) {
            for (Map.Entry<String, Integer> entry : entries) {
                System.out.print(entry.getKey() + ": " + entry.getValue() + ",   ");
            }


            EXAMPLE 2
             // map.keySet() to get all keys
            Set<String> keys = map.keySet();
            for (String key : keys) {
                System.out.print(key + ": " + map.get(key) + ",   ");
            }

            EXAMPLE 3
            // Using lambda expression to traverse the map
            map.forEach((key, value) -> System.out.print(key + ": " + value + ",   "));
            System.out.println();

 */

public class _17_MapIteration {

}