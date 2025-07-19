import java.util.Arrays;
import java.util.List;

public class _65_StreamAPI {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(4, 7, 6, 1, 9, 3);

        // Basic for loop
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + "  ");
        }

        // Enhanced for loop
        for (int num : nums) {
            System.out.print(num + "  ");
        }

        // forEach loop
        nums.forEach(n -> System.out.print(n + "  "));

        int sum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                num *= 2;
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
