package _04_DesignPatterns.Behavioral.Observer.bad;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DataSource datasource = new DataSource();

        Sheet2 sheet2 = new Sheet2();
        BarChart barChart = new BarChart();

        datasource.addDependent(barChart);
        datasource.addDependent(sheet2);

        datasource.setValues(List.of(5, 4, 1, 10));
        datasource.setValues(List.of(5, 2, 3, 4, 5));

    }
}
