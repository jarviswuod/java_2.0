package _04_DesignPatterns.Behavioral.Observer.bad;

import java.util.List;

public class Sheet2 {

    private int total;

    public int getTotal() {
        return total;
    }

    public int calculateTotal(List<Integer> values) {
        int sum = 0;

        for (Integer value : values) {
            sum += value;
        }
        System.out.println("Total : " + sum);
        return sum;
    }
}
