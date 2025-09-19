package _04_DesignPatterns.Behavioral.Template;

/*

    - CODE EXPLANATION:

    - SOLUTION 1:
        - Tea class:
            - We have a Tea class with some methods [boilWater(), pourWaterIntoCup(), brew()]


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


            - We also need a method to know if a customer needs conterments and to add those condements to the beveage
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

            - We need to make one final method named make beverage
                - THis is where we all the methods we ahve created in the corect order to make the Tea successfully

                    public class Tea {
                        public void makeBeverage() {
                            boilingWater();
                            pourWaterIntoCup();
                            brew();
                            addCondiments();
                        }
 
                        ...
                    }

        - Main class: Testing
            - We create the Tea object then we make a method call makeBeverage(). It all workd corretnly with either (y/n) from the user

        - Coffee class;
            -  The next part is creating coffee class which is also a beverage
            - It's all the same business logic as Tea class from head to toe, the only difference is brew() methos and what the condiment question; addCondiments(), customerWantsCondiments()
            - Idential methods (boilWater() and pourWaterToCup())


        - PROBLEM:
            - With more beverages added we tend to have lots of code duplication, we should resolve this issue, we can use polymophism and inhertance to help out first.
            - By using the polymorphism and inheritance, we have successfuly managed to use the stratergy pattern



    - SOLUTION 2: Strategy Pattern
        - Beverage interface: Strategy interface;
            - First we create Beverage class with  prepare method

                    public interface Beverage {

                        void prepare();
                    }


        - Concrete classes:
            - Tea class:
                - We create tea class while implementing the Beverage interface. Inside this concrete class we have methods specific to making only Tea

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
                    
                - The other 2 methods that we same across all Beverage classes(boilWater() and pourWaterToCup() will be added in a differenct class altogether)

            -COffee class:
                - It's all the same as the Tea methods, interms of all the methods and implmentations


            - Camomile class:
                - THis is actually very simple as we dont have to add anything inside it, we just brew() it

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
            - It's gonna contain our shared code
                - First we need field for referencing the particular beverage we are making. Its teh Beverage interface allwoing us to pass different types of beverage into the BeverageMaker
                - We also need a constructor and setBeverage() methods so that we could easily pchange the beverage we are going to prepare


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

            - We do the shared methods(boilWater() and pourIntoCup()). Next up is boilingWater and adding the water to cup methods. This are shared methods across every single  beverage

                    public class BeverageMaker {


                        private void boilingWater() {
                            System.out.println("Boiling water");
                        }

                        private void pourWaterIntoCup() {
                            System.out.println("Pouring water into cup");
                        }

                        ...
                    }

            - We create a method called makeBeverage() and in this method we'll  have our commom operation/steps/methods and then unique operations
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
            - first create a BeverageMaker object passing the beverage we wanna make and then we call the makeBeverage() method
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

        - Conslution:
            - Inside of beverageMaker we have defined the commom methods for making a beverage [boilWater() and addIntoCup() ] and then we have an interface Beverage which has prepare() method we also have our concreteBeverage implementations Camomile, Tea and Coffee all of which implmement the Beverage interface and this allows us to treat all beverage the same way in the beverageMaker class
            - From the beverageMaker class we specify the beverage when we create  the beverageMekter object or or we can set the bevegare in the setBeverage() methos and then we are delegating/forwaring the execution of tasks related to making a spesific beberage to a conreteBeverage object, this is done done via beverage.prepare() method inside the beverageMaker class


        - We just solved our peroblem using polymophism which lead to us using the stratergy pattern. We couls also solve the problem using inhertance; Teas, COffee and Camomile have things in common



    - SOLUTION 3: Template Pattern 
        - Bevarage class: Base class
            - We currently haveour template method with all the steps involved in creating a beverage

                    public abstract class Beverage {

                        public void prepare() {
                            boilingWater();
                            pourWaterIntoCup();
                            brew();
                            addCondiments();
                        }
                        }


            - Rem: boilWater() and pourIntoCup() are shared between all the concrete beverage classes hence we can actually implement the 2 steps inside of this beverage class
                    public abstract class Beverage {

                        public void prepare() {
                            boilingWater();
                            pourWaterIntoCup();
                            brew();
                            addCondiments();
                        }

                        private void boilingWater() {
                            System.out.println("Boiling water");
                        }

                        private void pourWaterIntoCup() {
                            System.out.println("Pouring water into cup");
                        }

                        ...
                    }
                    
            - Now in this template method , we can provide a brew() and addCondiments() methods
                - We can make brew() an abstract method
                - addCOndiments() method is optional to be overridden in subclasses 

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
                    - THe only method we have to implement is brew() method because it's an abstract method

                    - Optionally we Override the addCondiment() method depending on sub-class

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

                    - Same case aplies to COffee class



                - Camomile class:
                    - THis one is a bit different compared to COffee and Tea concrete classes
                    - All we have to for Camomile is inheriextend the abstract Beverage class and oveeride the abstract method bre(), nothing else is needed from it
                            public class Camomile extends Beverage {

                                @Override
                                protected void brew() {
                                    System.out.println("Brewing camomile for 3 minutes");
                                }
                            }

                - Main class: Client class;
                    - We create subclass instance and call the  prepare() method, with this everything works fine
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
