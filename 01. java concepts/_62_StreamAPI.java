import java.util.Arrays;
import java.util.List;

public class _62_StreamAPI {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(4, 7, 6, 1, 9, 3);

        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + "  ");
        }

        System.out.println();

        for (int num : nums) {
            System.out.print(num + "  ");
        }

        System.out.println();

        nums.forEach(n -> System.out.print(n + "  "));
        System.out.println();

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
