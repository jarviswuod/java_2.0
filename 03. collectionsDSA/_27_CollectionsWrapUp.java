import java.util.Arrays;
import java.util.List;

public class _27_CollectionsWrapUp {

    public static void main(String[] args) {

        int[] array1 = new int[] { 1, 2, 3, 95, 3, 2, 6 };

        Arrays.sort(array1);

        Integer[] array = new Integer[] { 1, 2, 3, 95, 3, 2, 6 };

        List<Integer> list1 = Arrays.asList(array);
        List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 9, 3);

        System.out.println(list1);
        System.out.println(list2);

        // Collections.sort(array, (a, b) -> a - b);
        // Collections.sort(array, Collections.reverseOrder());
    }
}
