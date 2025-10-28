package _04_DesignPatterns.Behavioral.Template;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Suppose we are designing some software that will be installed on a machine that makes hot beverages. At the beginning we have tea and coffee but, after some feedback from the customers, we needed to add some more beverages such as camomile tea


    - SOLUTION 1:
        - Tea class:
            - We have a Tea class with some methods(boilWater(), pourWaterIntoCup(), brew())

                    public class Tea {
                        private void boilingWater() {
                            System.out.println("Boiling water");
                        }

                        private void pourWaterIntoCup() {
                            System.out.println("Pouring water into cup");
                        }

                        private void brew() {
                            System.out.println("Brewing tea for 3 minutes");
                        }

                        ...
                    }


            - We also need a method to know if a customer needs condiments and then add the condiments to the beverage
                    public class Tea {
                        private void addCondiments() {
                            if (customerWantsCondiments()) {
                                System.out.println("Adding lemon to the tea");
                            }
                        }

                        private boolean customerWantsCondiments() {
                            System.out.println("Do you want condiments with your tea? (y/n)");
                            Scanner scanner = new Scanner(System.in);
                            String input = scanner.nextLine().toLowerCase();
                            scanner.close();
                            return input.equals("y");
                        }
 
                        ...
                    }


            - We need to make one final method named makeBeverage()
                - This is where we call all methods created in the correct order to make the Tea successfully

                    public class Tea {
                        public void makeBeverage() {
                            boilingWater();
                            pourWaterIntoCup();
                            brew();
                            addCondiments();
                        }
 
                        ...
                    }


        - Coffee class;
            -  The next part is creating coffee class which is also another beverage with same business logic as Tea classentirely.The only difference is brew() method and type of condiment added; addCondiments(), customerWantsCondiments()


        - Main class: Client class;
            - We create Tea object then call makeBeverage() method. It all works correctly with either (y/n) input from the user


        - PROBLEM:
            - With more beverages added we tend to have lots of code duplication which could be solved by either polymorphism and inhertance
            - NOTE:
                - By using the polymorphism, we'll successfuly managed to use the strategy pattern



    - SOLUTION 2: Strategy Pattern
        - Beverage interface: Base class
            - First we create Beverage class with prepare method

                    public interface Beverage {

                        void prepare();
                    }


        - Concrete classes:
            - Tea class:
                - We create Tea class by implementing the Beverage interface. Inside this concrete class we have methods specific to making only Tea

                    public class Tea implements Beverage {

                        private void brew() {
                            System.out.println("Brewing tea for 3 minutes");
                        }

                        private void addCondiments() {
                            if (customerWantsCondiments()) {
                                System.out.println("Adding lemon to the tea");
                            }
                        }

                        private boolean customerWantsCondiments() {
                            System.out.print("Do you want condiments with your tea? (y/n): ");
                            String input = scanner.nextLine().toLowerCase();
                            return input.equals("y");
                        }

                        ...
                    }

                - Inside the prepare() method we call the methods involved in making Tea(all the private methods)

                    public class Tea implements Beverage {

                        @Override
                        public void prepare() {
                            brew();
                            addCondiments();
                        }

                        ...
                    }
                    
                - The other 2 methods[boilWater() and pourWaterToCup()] are the same across all Beverage subclasses and will be added in a different class altogether


            - Coffee class:
                - It's all the same as the Tea methods, interms of all the methods and implementations


            - Camomile class:
                - This is actually very simple as we don't have to add anything inside it, we just brew()

                    public class Camomile implements Beverage {

                        @Override
                        public void prepare() {
                            brew();
                        }

                        private void brew() {
                            System.out.println("Brewing camomile for 3 minutes");
                        }
                    }


        - BeverageMaker class:
            - This class contains our shared code
                - First, we need field for referencing the particular beverage we are making. It's the Beverage interface allowing us to pass different types of beverage into the BeverageMaker
                - We also need a constructor and setBeverage() methods so that we could easily change the beverage we are going to prepare

                    public class BeverageMaker {

                        private Beverage beverage;

                        public BeverageMaker(Beverage beverage) {
                            this.beverage = beverage;
                        }

                        public void setBeverage(Beverage beverage) {
                            this.beverage = beverage;
                        }

                        ...
                    }

            - We do the shared methods(boilWater() and pourIntoCup()). Next up is boilingWater and adding the water to cup methods. This are shared methods across every single beverage

                    public class BeverageMaker {

                        private void boilingWater() {
                            System.out.println("Boiling water");
                        }

                        private void pourWaterIntoCup() {
                            System.out.println("Pouring water into cup");
                        }

                        ...
                    }

            - We create a method called makeBeverage() and in this method we'll have our commom operations/steps/methods and then unique operations
                    public class BeverageMaker {

                        public void makeBeverage() {
                            // Common operations
                            boilingWater();
                            pourWaterIntoCup();

                            // Unique operations
                            beverage.prepare();
                        }

                        ...
                    }



        - Main class: client class
            - First create a BeverageMaker object passing the beverage we wanna make and then we call the makeBeverage() method
                    public class Main {
                        public static void main(String[] args) {

                            try (Scanner scanner = new Scanner(System.in)) {
                                BeverageMaker beverageMaker = new BeverageMaker(new Tea(scanner));
                                beverageMaker.makeBeverage();

                                beverageMaker.setBeverage(new Coffee(scanner));
                                beverageMaker.makeBeverage();

                                beverageMaker.setBeverage(new Camomile());
                                beverageMaker.makeBeverage();
                            }
                        }
                    }


        - Conlusion:
            - Inside of BeverageMaker we have defined the commom methods for making a beverage(boilWater() and addIntoCup()) and then we have an interface Beverage which has prepare() method
            - We also have our ConcreteBeverage implementations of Camomile, Tea and Coffee all of which implement the Beverage interface and allows us to treat all beverage the same way in the BeverageMaker class
            - From the BeverageMaker class we specify the beverage when we create the BeverageMaker object or we can set the beverage in the setBeverage() method and then delegate/forward the execution of tasks related to making a specific beverage to a ConcreteBeverage object, this is done via beverage.prepare() method inside the BeverageMaker class


        - We just solved our problem using polymorphism which lead to us using the strategy pattern



    - SOLUTION 3: Template Pattern
        - We could also solve the problem using inheritance; Tea, Coffee and Camomile have things in common

        - Beverage class: Base class
            - We currently have our template method with all the steps involved in creating a beverage

                    public abstract class Beverage {

                        public void prepare() {
                            boilingWater();
                            pourWaterIntoCup();
                            brew();
                            addCondiments();
                        }
                    }


            - NOTE:
                - boilWater() and pourIntoCup() are shared across all concrete beverage classes hence we can actually implement the 2 steps inside of this Beverage class

                    public abstract class Beverage {

                        private void boilingWater() {
                            System.out.println("Boiling water");
                        }

                        private void pourWaterIntoCup() {
                            System.out.println("Pouring water into cup");
                        }

                        ...
                    }


            - Now in this template method, we can provide a brew() and addCondiments() method
                - We can make brew() an abstract method
                - addCondiments() method is made optional as it can be overriden or not in subclasses 

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

                        ...
                    }


        - Concrete classes implementations:
            - Tea class:
                - The only method we have to implement is brew() method because it's an abstract method

                - Optionally we override the addCondiments() method depending on sub-class

                        public class Tea extends Beverage {

                            @Override
                            protected void brew() {
                                System.out.println("Brewing tea for 3 minutes");
                            }

                            @Override
                            protected void addCondiments() {
                                if (customerWantsCondiments()) {
                                    System.out.println("Adding lemon to the tea");
                                }
                            }

                            private boolean customerWantsCondiments() {
                                System.out.print("Do you want condiments with your tea? (y/n): ");
                                String input = scanner.nextLine().toLowerCase();
                                return input.equals("y");
                            }

                            ...
                        }

            - Same case aplies to Coffee class


            - Camomile class:
                - This one is a bit different compared to Coffee and Tea concrete classes
                - All we have for Camomile is inherit/extend the abstract Beverage class and override the abstract method brew(), nothing else is needed from it

                        public class Camomile extends Beverage {

                            @Override
                            protected void brew() {
                                System.out.println("Brewing camomile for 3 minutes");
                            }
                        }


        - Main class: Client class;
            - We create Tea and Camomile instances then call the prepare() method.
            - Everything works fine
                    public class Main {
                        public static void main(String[] args) {


                            Tea tea = new Tea();
                            tea.prepare();

                            System.out.println();

                            Camomile camomile = new Camomile();
                            camomile.prepare();
                        }
                    }

 */

public class Explanation {

}
