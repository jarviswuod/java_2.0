package _03_SOLID.D;

/*

    NOTES:
    - Dependecy Inversion Principle: High-level modules should not depend on low-level modules. Both should depend on abstractions
    - It's a strategy of depending upon interfaces/ abstract classes rather than upon concrete classes.
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


        - ISSUE:
            - Once we create a Car object, we have way of changing the type of Engine
                public static void main(String[] args) {

                    Car car = new Car();
                    car.startCar();
                }

            - We have a Car class which has a dependency on concrete Engine class
            - A car class directly creates an instance of the Engine class, leading to a tight coupling between Car and Engine. This means if something under the Engine class changes, it my affect the Car class changes. This is violation of Dependency Injection


    - GOOD CODE EXPLAINED:
        - We fix the issueby introducing an interface/ abstraction between the Car and Engine class allowing Car to depend on abstraction rather than concrete implementation
            public interface IEngine {
                void start();
            }

        - We implemet te interface to the Car class and introduce a field and a contructor of the interface we created, IEngine interface. This makes it possible to instaciate the Car class with any IEngine sub-class dynamically at runtime
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

        - The advantage of this method is that it provides as with the flexibility because whenever we create a Car object at runtime we can pass in any type of Engine we want the Car to be built with

        - Advantages of Dependecy Injection;
            1. It promotes loose coupling between components by removing direct dependecies so that the componenets rely on abstractions rather than concrete implementations making them more indepedent and easy to maintain
            2. It simplifies unit testing by allowing componenets to be easily replaced with mock or stub implemetation during testing this enables isolated testing of individual componenets without relying on dependecies
            3. It impoves flexiblity because we could swap out dependecies at runtime

 */

public class Notes {

}
