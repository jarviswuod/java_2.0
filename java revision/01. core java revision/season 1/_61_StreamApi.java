/*

    NOTES:
    - Looping through a collection framework
          1. Basic for loop
          2. Enhanced for loop
          3. For Each loop

 */

import java.util.Arrays;
import java.util.List;

public class _61_StreamApi {

    public static void main(String[] args) {

        List<Integer> array = Arrays.asList(102, 45, 29, 57);

        System.out.println("List Array : " + array);

        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + "  ");
        }
        System.out.println();

        for (Integer num : array) {
            System.out.print(num + "  ");
        }
        System.out.println();

        array.forEach(value -> System.out.print(value + "  "));
        System.out.println();

    }
}