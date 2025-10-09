/*

    NOTES:
    - list.toArray(new Integer[0])

    - Any value reasoning
        - Less value - results in creation of the exact same array length for element in the collection/ArrayList
        - More values - result in creation of a bigger array with null values
        - Exact values length - create an array of exact element size and copies the element values to it

 */

import java.util.List;

public class _05_ToArray {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer[] array = list.toArray(new Integer[0]);

        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("--- --- --- --- --- --- --- ");

        List<String> list2 = List.of("Jarvis", "Wuod", "Random", "Just");
        String[] array2 = list2.toArray(new String[0]);
        for (String string : array2) {
            System.out.print(string + " ");
        }
        System.out.println();

    }
}
