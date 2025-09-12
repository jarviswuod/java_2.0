package _04_DesignPatterns.Behavioral.Template.goodTemplateMethod;

public abstract class Beverage {

    public void prepare() {
        boilingWater();
        pourWaterIntoCup();
        brew();
        addCondiments();
    }

    protected void addCondiments() {
        // can be overridden
    }

    protected abstract void brew();

    private void boilingWater() {
        System.out.println("Boiling water");
    }

    private void pourWaterIntoCup() {
        System.out.println("Pouring water into cup");
    }
}
