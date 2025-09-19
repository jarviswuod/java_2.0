package _04_DesignPatterns.Behavioral.Template.good.Strategy;

public class Camomile implements Beverage {

    @Override
    public void prepare() {
        brew();
    }

    private void brew() {
        System.out.println("Brewing camomile for 3 minutes");
    }
}
