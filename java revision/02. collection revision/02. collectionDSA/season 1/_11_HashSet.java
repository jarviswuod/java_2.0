/*

    NOTES:
    - HashSet Methods:
        - Basic Set:
            - add(elementName)
            - remove(elementName)
            - contains(elementName)
            - addAll(Collection c)
            - removeAll(Collection c)
            - retainAll(Collection c)
            - containsAll(Collection c)
            - size()
            - isEmpty()
            - clear()

        - Iteration:
            - iterator()
            - spliterator()
            - forEach(Consumer)

        - Array ops:
            - toArray()
            - toArray(T[])


    - HashSet Methods in action:
        Set<Integer> A = new HashSet<>(List.of(1, 2, 3, 4));
        Set<Integer> B = new HashSet<>(List.of(3, 4, 5, 6));

            - A.containsAll(B); // false → A doesn't have 5, 6
            - A.addAll(B); // A becomes [1, 2, 3, 4, 5, 6]
            - A.removeAll(B); // A becomes [1, 2] (removes 3, 4, 5, 6)
            - A.retainAll(B); // A becomes [3, 4] (keeps only common)


    - NOTE:
        - B always remains unchanged
        - In a hashset the deletion & addition take the same amount of time, O(1) on average
        - HashSet is not ordered, so the order of elements may change
        - HashSet cannot be sorted
        - HashSet does not allow duplicate elements

 */

public class _11_HashSet {

}