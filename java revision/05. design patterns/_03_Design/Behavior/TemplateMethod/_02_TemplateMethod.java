package _03_Design.Behavior.TemplateMethod;

/*

    NOTES:
    - Is a behaviora pattern that defines an algorithm skeleton and lets the specific implementation happen under sub classes
    - Key players:
        - Abstract class
        - Sub classes

    - Example:
        - Beverage
        - Strategy pattern



            public class _02_TemplateMethod {
                public static void main(String[] args) {

                    _02_Tea tea = new _02_Tea();
                    tea.makeBeverage();
                    System.out.println();

                    _02_Camomile camo_02_Camomile = new _02_Camomile();
                    camo_02_Camomile.makeBeverage();
                    System.out.println();

                    _02_Coffee coffee = new _02_Coffee();
                    coffee.makeBeverage();
                    System.out.println();
                }
            }


*/

public class _02_TemplateMethod {
    public static void main(String[] args) {

        _02_BeverageMaker beverageMaker = new _02_BeverageMaker(new _02_Tea());
        beverageMaker.makeBeverage();
        System.out.println();

        beverageMaker.setBeverage(new _02_Camomile());
        beverageMaker.makeBeverage();
        System.out.println();

        beverageMaker.setBeverage(new _02_Coffee());
        beverageMaker.makeBeverage();
        System.out.println();
    }
}

class _02_BeverageMaker {

    _02_Beverage beverage;

    public _02_BeverageMaker(_02_Beverage beverage) {
        this.beverage = beverage;
    }

    public void setBeverage(_02_Beverage beverage) {
        this.beverage = beverage;
    }

    public void makeBeverage() {
        beverage.makeBeverage();
    }
}

abstract class _02_Beverage {

    public void makeBeverage() {
        boilWater();
        pourToCup();
        screw();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boil water");
    }

    private void pourToCup() {
        System.out.println("Pour water into cup");
    }

    protected abstract void screw();

    protected void addCondiments() {
    }
}

class _02_Tea extends _02_Beverage {

    @Override
    protected void screw() {
        System.out.println("Screw for 5 minutes");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding tea leaves to tea");
    }
}

class _02_Camomile extends _02_Beverage {

    @Override
    protected void screw() {
        System.out.println("Screw for 4 minutes");
    }

}

class _02_Coffee extends _02_Beverage {

    @Override
    protected void screw() {
        System.out.println("Screw for 3 minutes");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding milk to coffee");
    }
}
