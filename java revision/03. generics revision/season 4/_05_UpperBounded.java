import java.util.List;

public class _05_UpperBounded {
    public static void main(String[] args) {

        List<Number> numList = List.of(9, 7, 2, 4, 3, 8);
        add(numList);

        List<Integer> intList = List.of(9, 7, 2, 4, 3, 8);
        addExt(intList);

    }

    public static void add(List<Number> list) {

        double sum = 0;

        for (Number num : list) {
            sum += num.doubleValue();
        }

        System.out.println("Sum : " + sum);
    }

    public static void addExt(List<? extends Number> list) {

        double sum = 0;

        for (Number num : list) {
            sum += num.doubleValue();
        }

        System.out.println("Sum : " + sum);
    }
}
