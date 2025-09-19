package _04_DesignPatterns.Behavioral.Template.good.TemplateMethod;

public class Camomile extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Brewing camomile for 3 minutes");
    }
}
