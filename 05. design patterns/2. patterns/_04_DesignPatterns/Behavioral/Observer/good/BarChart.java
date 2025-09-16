package _04_DesignPatterns.Behavioral.Observer.good;

public class BarChart implements Observer {

    private DataSource dataSource;

    public BarChart(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Rendering Barchart with new values");
    }
}