package _03_SOLID.D;

/*

    NOTES:
    - Dependecy Inversion Principle:
        - States that high-level modules should not depend on low-level modules. Both should depend on abstractions
        - It's a strategy of depending upon interfaces/ abstract classes rather than upon concrete classes
        - It promotes decoupling between modules and promotes the use of interfaces/ abstract to define dependency allowing for more flexible and testable code


    - BAD CODE EXPLAINED:
        - We create an Engine class which only has one method start()

                public class Engine {

                    public void start() {
                        System.out.println("Engine started");
                    }
                }

        - We then create a Car class which is a composition of other classes inclusive of Engine class. We can have other classes like Seats, Chassis, Doors, wheels, etc
                public class Car {

                    private Engine engine;

                    public Car() {
                        this.engine = new Engine();
                    }

                    public void startCar() {
                        engine.start();
                        System.out.println("Car started");
                    }
                }

        - The Car class has direct dependency on the concrete Engine class. We say this because on the Car constructor we have created an Engine instance


        - ISSUE:
            - Once we create a Car object, we have way of changing the type of Engine
                    public class Main {
                        public static void main(String[] args) {

                            Car car = new Car();
                            car.startCar();
                        }
                    }

            - We have a Car class which has a dependency on concrete Engine class
            - The car class directly creates an instance of the Engine class, leading to a tight coupling between Car and Engine. This means if something under the Engine class changes, it my affect the Car class changes. This is violation of Dependency Injection


        - SOLUTION:
            - To solve the issue we'll introduce an interface or abstract class between the Engine and Car class.
            - This allows Car to depend on abstraction instead of concrete Engine implementation



    - GOOD CODE EXPLAINED:
        - We create an interface called IEngine which has a start() method as all engines should

                public interface IEngine {

                    void start();
                }

        - We then implement the IEngine interface to Engine class with a custom start() method
                public class Engine implements IEngine {

                    @Override
                    public void start() {
                        System.out.println("Engine started");
                    }
                }

        - We currently have Car class depending on Engine class rather than an interface, we need to change that
            - OLD ::
                public class Car {

                    private Engine engine;

                    public Car() {
                        this.engine = new Engine();
                    }

                    public void startCar() {
                        engine.start();
                        System.out.println("Car started");
                    }
                }


            - NEW ::
                public class Car {

                    private IEngine engine;

                    public Car(IEngine engine) {
                        this.engine = engine;
                    }

                    public void startCar() {
                        engine.start();
                        System.out.println("Car started");
                    }
                }


        - The advantage of this method is that it provides as with the flexibility to pass any type of Engine class we want the Car to be built with at runtime
            - This is called dependecy Injection, as we inject the dependency into the class

                public class Main {
                    public static void main(String[] args) {

                        Car car = new Car(new Engine());
                        // Car car = new Car(new ElectricEngine());

                        car.startCar();
                    }
                }

        - Advantages of Dependecy Injection;
            1. It promotes loose coupling between components by removing direct dependecies so that the componenets rely on abstractions rather than concrete implementations making them more indepedent and easy to maintain
            2. It simplifies unit testing by allowing componenets to be easily replaced with mock or stub implemetation during testing this enables isolated testing of individual componenets without relying on dependecies
            3. It impoves flexiblity because we could swap out dependecies at runtime

 */

public class Notes {

}
