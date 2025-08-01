/*

    NOTES:
      - Arrays.asList(...) creates a fixed-size list backed by the specified array
      - Looping over an array or collection
           - Basic for loop
           - Enhanced for loop
           - forEach loop

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _65_StreamAPI {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(4, 7, 6, 1, 9, 3);
        List<Integer> nums = new ArrayList<>(list);

        // Basic for loop
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "  ");
        }

        // Enhanced for loop
        for (int num : list) {
            System.out.print(num + "  ");
        }

        // forEach loop
        list.forEach(n -> System.out.print(n + "  "));

        int sum = 0;
        for (int num : list) {
            if (num % 2 == 0) {
                num *= 2;
                sum += num;
            }
        }

        System.out.println();
        System.out.println();

        System.out.println(sum);
        System.out.println(nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, Integer::sum));
    }
}
