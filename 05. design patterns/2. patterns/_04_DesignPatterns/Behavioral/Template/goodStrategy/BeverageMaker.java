package _04_DesignPatterns.Behavioral.Template.goodStrategy;

public class BeverageMaker {

    private IBeverage beverage;

    public BeverageMaker(IBeverage beverage) {
        this.beverage = beverage;
    }

    public void setBeverage(IBeverage beverage) {
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
