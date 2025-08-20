/*

    NOTES:
    - Set Types:
        - HashSet
        - SortedSet -> NavigableSet -> TreeSet

    - Set Creation
        - default constructor -> HashSet<>();
        - Parametized way -> HashSet<>(Collection c);
        - addAll() -> list1.add(Collection c)

    - Set features:
        - no duplicate elements
        - no multiple null values
        - no insertion order
        - stored in a HashMap

    - Set methods:
        - size()
        - add(element)
        - remove(element)
        - clear()
        - isEmpty()
        - contains(element)
        - addAll(Collection c)
        - removeAll(Collection c)
        - retainAll(Collection c)
        - containsAll(Collection c)

    - Iterating over set
        - Enhanced for loop
        - forEach loop
        - stream.forEach
        - while loop Iterator
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        - for loop Iterator
            for(Iterator<Integer> iterator =  set.iterator(); iterator.hasNext();) {
                System.out.println(iterator.next());
            }

    - Sorting Set
        - Collections.sort(set)
        - Collections.reverse(set)
        - Collections.sort(set, (arg0, arg1) -> arg0, arg1);

 */

public class _03_Set {

}
