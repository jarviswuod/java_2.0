package _04_DesignPatterns.Behavioral.Template.good.Strategy;

public class BeverageMaker {

    private Beverage beverage;

    public BeverageMaker(Beverage beverage) {
        this.beverage = beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public void makeBeverage() {
        // Common operations
        boilingWater();
        pourWaterIntoCup();

        // Unique operations
        beverage.prepare();
    }

    private void boilingWater() {
        System.out.println("Boiling water");
    }

    private void pourWaterIntoCup() {
        System.out.println("Pouring water into cup");
    }
}
