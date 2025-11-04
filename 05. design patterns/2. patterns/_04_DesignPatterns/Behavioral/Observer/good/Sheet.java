package _04_DesignPatterns.Behavioral.Observer.good;

import java.util.List;

public class Sheet implements Observer {

    private int total;
    private DataSource dataSource;

    public Sheet(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public void update() {
        total = calculateTotal(dataSource.getValues());
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
