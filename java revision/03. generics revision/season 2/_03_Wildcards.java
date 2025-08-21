import java.util.ArrayList;
import java.util.List;

public class _03_Wildcards {
    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        intList.add(34);
        intList.add(22);
        intList.add(11);
        intList.add(44);

        System.out.println(addInt(intList));
        System.out.println(addNumber_(intList));

        List<Number> intNumber = new ArrayList<>();
        intNumber.add(34);
        intNumber.add(22);
        intNumber.add(11);
        intNumber.add(44);

        System.out.println(addNum(intNumber));
        System.out.println(addNumber_(intNumber));

    }

    public static double addNumber_(List<? extends Number> list) {
        double sum = 0;

        for (Number value : list) {
            sum += value.doubleValue();
        }

        return sum;
    }

    public static <T extends Number> double addNumber(List<T> list) {
        double sum = 0;

        for (Number value : list) {
            sum += value.doubleValue();
        }

        return sum;
    }

    public static double addNum(List<Number> list) {
        double sum = 0;

        for (Number value : list) {
            sum += value.doubleValue();
        }

        return sum;
    }

    public static int addInt(List<Integer> list) {
        int sum = 0;

        for (Integer value : list) {
            sum += value;
        }

        return sum;
    }
}