package _03_Design.Behavior.TemplateMethod;

/*

    NOTES:
    - Template method is a design pattern that introduces a skeleton of an algorithm allowing concrete classes to implement specific detials of the algo
    - It can be achieved with either the polymorphism (Strategy pattern) or inheritance (Template method pattern)

    - We have 2 key players:
        - Abstract class:
            - Provides a skeleton to be followed
            - Inside here we have a method that calls other methods, the other methods can be protected while this one method should be public to allow for calling by the client at a specific object instance

        - Concrete class:
            - Provides specific/ custom details defined by the abstract class


    // FIRST ATTEMPT::: ::: ::: :::
            abstract class Beverage {
                
                protected void boilWater() {
                    System.out.println("Boil water for 10 mins");
                }

                protected void pourIntoCup() {
                    System.out.println("Water water into cup");
                }

                protected abstract void chill();

                protected void addCondiment() {
                }

                public void makeBeverage() {
                    boilWater();
                    pourIntoCup();
                    chill();
                    addCondiment();
                }
            }

            class Tea extends Beverage {

                @Override
                protected void chill() {
                    System.out.println("Chill for a 5 mins");
                }

                @Override
                protected void addCondiment() {
                    System.out.println("Since this is tea, you will have tea");
                }
            }

            class Coffee extends Beverage {

                @Override
                protected void chill() {
                    System.out.println("Chill for a 3 mins");
                }

                @Override
                protected void addCondiment() {
                    System.out.println("Since this is Coffee, you will have coffee");
                }
            }

            class Camomile extends Beverage {

                @Override
                protected void chill() {
                    System.out.println("Chill for a 5 mins");
                }
            }


    // SECOND ATTEMPT::: ::: ::: :::
    - Difference between inheritance and polymorphism interms of functionality


    // -- -- -- -- INHERITANCE -- -- -- -- 

            public class Notes {

                public static void main(String[] args) {

                    Tea tea = new Tea();
                    tea.makeBeverage();

                    System.out.println("--------------------------------");

                    Camomile camomile = new Camomile();
                    camomile.makeBeverage();

                    System.out.println("--------------------------------");

                    Coffee coffee = new Coffee();
                    coffee.makeBeverage();

                }
            }

            abstract class Beverage {
                protected void boilWater() {
                    System.out.println("Boil water for 5 mins");
                }

                protected void pourIntocup() {
                    System.out.println("Pour water into cup");
                }

                protected abstract void brew();

                protected void addCondiment() {
                }

                public void makeBeverage() {
                    boilWater();
                    pourIntocup();
                    brew();
                    addCondiment();
                }
            }

            class Tea extends Beverage {

                @Override
                protected void brew() {
                    System.out.println("Brew for 5 minutes");
                }

                protected void addCondiment() {
                    System.out.println("Add condiment to tea");
                }
            }

            class Camomile extends Beverage {

                @Override
                protected void brew() {
                    System.out.println("Brew for 4 minutes");
                }
            }

            class Coffee extends Beverage {

                @Override
                protected void brew() {
                    System.out.println("Brew for 15 minutes");
                }

                protected void addCondiment() {
                    System.out.println("Add condiment to coffee");
                }
            }



    // -- -- -- -- POLYMORPHISM -- -- -- -- 


            public class Notes {

                public static void main(String[] args) {

                    BeverageMaker beverageMaker = new BeverageMaker(new Tea());
                    beverageMaker.makeBeverage();

                    System.out.println("-------- ----------------- ----------------- -----------");
                    beverageMaker.setBeverage(new Camomile());
                    beverageMaker.makeBeverage();

                    System.out.println("-------- ----------------- ----------------- -----------");
                    beverageMaker.setBeverage(new Coffee());
                    beverageMaker.makeBeverage();

                }
            }

            interface Beverage {
                void prepare();
            }

            class BeverageMaker {

                private Beverage beverage;

                public BeverageMaker(Beverage beverage) {
                    this.beverage = beverage;
                }

                public void setBeverage(Beverage beverage) {
                    this.beverage = beverage;
                }

                public void makeBeverage() {
                    boilWater();
                    pourIntoCup();
                    beverage.prepare();
                }

                private void boilWater() {
                    System.out.println("Boil water");
                }

                private void pourIntoCup() {
                    System.out.println("Pour water into cup");
                }

            }

            class Tea implements Beverage {

                @Override
                public void prepare() {
                    brew();
                    addCondiment();
                }

                private void brew() {
                    System.out.println("Brew for 5 minutes");
                }

                private void addCondiment() {
                    System.out.println("Add lemon to tea");
                }
            }

            class Coffee implements Beverage {

                @Override
                public void prepare() {
                    brew();
                    addCondiment();
                }

                private void brew() {
                    System.out.println("Brew for 15 minutes");
                }

                private void addCondiment() {
                    System.out.println("Add cream to coffee");
                }
            }

            class Camomile implements Beverage {

                @Override
                public void prepare() {
                    brew();
                }

                private void brew() {
                    System.out.println("Brew for 3 minutes");
                }
            }


    // THIRD ATTEMPT::: ::: ::: :::

    - Is a behavioral pattern which provides a skeleton of an algorithm with specific implementations done by subclasses

    - 2 main key players:
        - Abstract class:
            - Provides a template of algorithm

        - Concrete classes:
            - Implmenents specific algorithm details after extending the abstract class




            // -- -- -- -- -- -- -- INHERITANCE[TEMPLATE METHOD] -- -- -- -- -- -- --

            public class Notes {
                public static void main(String[] args) {

                    Tea tea = new Tea();
                    tea.makeBeverage();

                    System.out.println();

                    Coffee coffee = new Coffee();
                    coffee.makeBeverage();

                    System.out.println();

                    Camomile camomile = new Camomile();
                    camomile.makeBeverage();
                }
            }

            abstract class Beverage {

                public void makeBeverage() {
                    boilWater();
                    pourIntoCup();
                    brew();
                    addCondiments();
                }

                protected void boilWater() {
                    System.out.println("Boil water");
                }

                protected void pourIntoCup() {
                    System.out.println("Pour water int cups");
                }

                protected abstract void brew();

                protected void addCondiments() {
                }
            }

            class Tea extends Beverage {
                @Override
                protected void brew() {
                    System.out.println("Brew for 5 minutes");
                }

                @Override
                protected void addCondiments() {
                    System.out.println("Add lemon to tea");
                }
            }

            class Camomile extends Beverage {
                @Override
                protected void brew() {
                    System.out.println("Brew for 5 minutes");
                }
            }

            class Coffee extends Beverage {
                @Override
                protected void brew() {
                    System.out.println("Brew for 5 minutes");
                }

                @Override
                protected void addCondiments() {
                    System.out.println("Add cream to coffee");
                }
            }



        // -- -- -- -- -- -- -- POLYMORPHISM[STRATEGY PATTERN] -- -- -- -- -- -- --

            public class Notes {
                public static void main(String[] args) {

                    BeverageMaker beverageMaker = new BeverageMaker(new Tea());
                    beverageMaker.makeBeverage();

                    System.out.println("-------------------------------------------");

                    beverageMaker.setBeverage(new Camomile());
                    beverageMaker.makeBeverage();

                    System.out.println("-------------------------------------------");

                    beverageMaker.setBeverage(new Coffee());
                    beverageMaker.makeBeverage();

                }
            }

            interface Beverage {
                void prepare();

            }

            class BeverageMaker {
                private Beverage beverage;

                public BeverageMaker(Beverage beverage) {
                    this.beverage = beverage;
                }

                public void setBeverage(Beverage beverage) {
                    this.beverage = beverage;
                }

                public void makeBeverage() {
                    boilWater();
                    pourIntoCup();
                    beverage.prepare();
                }

                private void pourIntoCup() {
                    System.out.println("Pour water into cup");
                }

                private void boilWater() {
                    System.out.println("Boil water");
                }
            }

            class Tea implements Beverage {

                @Override
                public void prepare() {
                    brew();
                    addCondiments();
                }

                private void brew() {
                    System.out.println("Brewing tea for 5 mins");
                }

                private void addCondiments() {
                    System.out.println("Adding lemon to tea");
                }
            }

            class Coffee implements Beverage {

                @Override
                public void prepare() {
                    brew();
                    addCondiments();
                }

                private void brew() {
                    System.out.println("Brewing coofee for 6 mins");
                }

                private void addCondiments() {
                    System.out.println("Adding cream to coofee");
                }
            }

            class Camomile implements Beverage {

                @Override
                public void prepare() {
                    brew();
                }

                private void brew() {
                    System.out.println("Brewing camomile for 3 mins");
                }
            }

 */

public class Notes {
}