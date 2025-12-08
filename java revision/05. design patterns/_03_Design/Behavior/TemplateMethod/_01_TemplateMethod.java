package _03_Design.Behavior.TemplateMethod;

/*

    NOTES:
    - Is a behavioral pattern that introduces an algorithm and lets the specific implementation be done by subclasses
    - Key players:
        - Abstract class
        - Concrete classes

    - Example:
        - BeverageMaker


                public class _01_TemplateMethod {
                    public static void main(String[] args) {

                        _BeverageMaker beverageMaker = new _BeverageMaker(new _Tea());
                        beverageMaker.makeBeverage();
                        System.out.println();

                        beverageMaker.setBeverage(new _Camomile());
                        beverageMaker.makeBeverage();
                        System.out.println();
                    }
                }

                class _BeverageMaker {

                    private _Beverage beverage;

                    public _BeverageMaker(_Beverage beverage) {
                        this.beverage = beverage;
                    }

                    public _Beverage getBeverage() {
                        return beverage;
                    }

                    public void setBeverage(_Beverage beverage) {
                        this.beverage = beverage;
                    }

                    public void makeBeverage() {
                        beverage.makeBeverage();
                    }
                }

                abstract class _Beverage {

                    public void makeBeverage() {
                        boilWater();
                        addToCup();
                        brew();
                        addCondiments();
                    }

                    private void boilWater() {
                        System.out.println("Boil wanter for 5 minutes");
                    }

                    private void addToCup() {
                        System.out.println("Pour water to cup");
                    }

                    protected abstract void brew();

                    protected void addCondiments() {
                    };
                }

                class _Tea extends _Beverage {

                    @Override
                    protected void brew() {
                        System.out.println("Brew for 5 minutes");
                    }

                    @Override
                    protected void addCondiments() {
                        System.out.println("Adding tea bag to Tea");
                    }

                }

                class _Coffee extends _Beverage {

                    @Override
                    protected void brew() {
                        System.out.println("Brew for 3 minutes");
                    }

                    @Override
                    protected void addCondiments() {
                        System.out.println("Adding milk to Coffee");
                    }
                }

                class _Camomile extends _Beverage {

                    @Override
                    protected void brew() {
                        System.out.println("Brew for 7 minutes");
                    }

                    @Override
                    protected void addCondiments() {
                    }
                }




        // -------------------------------------------------------------------------------------------
        // -------------------------------------------------------------------------------------------
        // -------------------------------------------------------------------------------------------
        // -------------------------------------------------------------------------------------------

        // PART ONE
        // -------------------------------------------------------------------------------------------
                    public class _01_TemplateMethod {
                        public static void main(String[] args) {

                            _Tea tea = new _Tea();
                            tea.makeBeverage();
                            System.out.println();

                            _Coffee coffee = new _Coffee();
                            coffee.makeBeverage();
                            System.out.println();

                            _Camomile camomile = new _Camomile();
                            camomile.makeBeverage();
                            System.out.println();

                        }
                    }



        // PART TWO
        // -------------------------------------------------------------------------------------------



 */

public class _01_TemplateMethod {
    public static void main(String[] args) {

        _BeverageMaker beverageMaker = new _BeverageMaker(new _Tea());
        beverageMaker.makeBeverage();
        System.out.println();

        beverageMaker.setBeverage(new _Coffee());
        beverageMaker.makeBeverage();
        System.out.println();

        beverageMaker.setBeverage(new _Camomile());
        beverageMaker.makeBeverage();
        System.out.println();
    }
}

class _BeverageMaker {

    private _Beverage beverage;

    public _BeverageMaker(_Beverage beverage) {
        this.beverage = beverage;
    }

    public _Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(_Beverage beverage) {
        this.beverage = beverage;
    }

    public void makeBeverage() {
        boilWater();
        pourToCup();
        beverage.makeBeverage();
    }

    private void boilWater() {
        System.out.println("Boil water");
    }

    private void pourToCup() {
        System.out.println("Pour to cup");
    }

}

interface _Beverage {

    void makeBeverage();
}

class _Tea implements _Beverage {

    @Override
    public void makeBeverage() {

        brew();
        addCondiments();
    }

    protected void brew() {
        System.out.println("Brew for 5 minutes");
    }

    protected void addCondiments() {
        System.out.println("Adding Teabug to Tea");
    }
}

class _Coffee implements _Beverage {

    @Override
    public void makeBeverage() {
        brew();
        addCondiments();
    }

    protected void brew() {
        System.out.println("Brew for 3 minutes");
    }

    protected void addCondiments() {
        System.out.println("Adding milk to Tea");
    }
}

class _Camomile implements _Beverage {

    @Override
    public void makeBeverage() {
        brew();
        addCondiments();
    }

    protected void brew() {
        System.out.println("Brew for 5 minutes");
    }

    protected void addCondiments() {
    }
}
