package _04_DesignPatterns.Behavioral.Template.goodStrategy;

public class Camomile implements IBeverage {

    @Override
    public void prepare() {
        brew();
    }

    private void brew() {
        System.out.println("Brewing camomile for 3 minutes");
    }
}
