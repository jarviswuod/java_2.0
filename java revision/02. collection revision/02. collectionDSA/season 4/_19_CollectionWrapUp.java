/*

    NOTES:
    - Converting to an array from a Collection:
        - list2.toArray(new Integer[0]);



    - Generics concept:
        - List.of(1, 2, 3, 6, 8, 4, 90);



    - Other Arrays summary concepts:
        - Lowercase:
            - int[] arraysm = new int[] { 1, 5, 8, 7, 1 };


        - Uppercase:
            - Integer[] array = new Integer[] { 1, 5, 8, 7, 1 };
            - Arrays.sort(array);


        - asList() method:
            - List<Integer> list1 = Arrays.asList(1, 3, 7, 9);
            - List<Integer> list2 = Arrays.asList(array);

 */

import java.util.List;
import java.util.Arrays;

public class _19_CollectionWrapUp {
    public static void main(String[] args) {

        Integer[] array = { 1, 5, 8, 7, 1 };
        List<Integer> list2 = Arrays.asList(array);

        Arrays.sort(array);
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println("----");

        List<Integer> list1 = Arrays.asList(1, 3, 7, 9);
        System.out.println(list1);
        System.out.println(list2);

        int[] arraysm = new int[] { 1, 5, 8, 7, 1 };
        System.out.println(arraysm);

        List.of(1, 2, 3, 6, 8, 4, 90);

    }
}
