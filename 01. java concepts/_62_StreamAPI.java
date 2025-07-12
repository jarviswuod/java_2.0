import java.util.Arrays;
import java.util.List;

public class _62_StreamAPI {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(4, 7, 6, 1, 9, 3);

        // Method 1 looping
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + "  ");
        }

        // Method 2 looping
        for (int num : nums) {
            System.out.print(num + "  ");
        }

        // Method 3 looping
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
