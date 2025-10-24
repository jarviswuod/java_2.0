package _02_OopPrinciples.Composition;

/*

    NOTES:
    - Composition;
        - Composition involves creating complex objects by combining simpler objects or components
        - In composition, objects are assembled together to form large structures with each component's object maintaining it's own state and behavior
        - Composition is often described in terms of a 'has-a' relationship


    - GOOD CODE EXPLANATION:
        - In this example we have a load of items/parts that make up a Car i.e Chassis, Wheels, Engine. All these are individual and complete Objects on their own containing both fields and complete methods

                public class Chassis {
                    public void support() {...}
                }

                public class Engine {
                    public void start() {...}
                }

                public class Wheels {
                    public void rotate() {...}
                }


        - The Chassis, Engine, Wheels, Seats etc are all things that make up a Car, this means that under the Car class we use all the individual classes above with each component being a separate class doing an independent role

                public class Car {

                    private Engine engine = new Engine();
                    private Wheels wheels = new Wheels();
                    private Chassis chassis = new Chassis();
                    private Seats seats = new Seats();

                    ...
                }


        - The Car class delegates tasks to the individual components rather than doing all that work itself

                public void startCar() {

                    engine.start();
                    wheels.rotate();
                    chassis.support();
                    seats.sit();

                    System.out.println("Car started");
                }

        - This means that when we create a Car instance and call the startCar() method every component will be delegated it's specific/ unique role and the car starts successfully

                public class Main {
                    public static void main(String[] args) {

                        Car car = new Car();
                        car.startCar();
                    }
                }



    - COMPOSITION VS INHERITANCE:
        - When to use Composition:
            - When you need more flexibility in constructing objects by assembling smaller, reusable components
            - When there is no clear 'is-a' relationship between classes, and a 'has-a' relationship is more appropriate
            - When you want to avoid the limitation of inheritance, such as tight coupling and the Fragile-Base class problem

        - When to use inheritance:
            - When there is a clear 'is-a' relationship between classes, and subclass objects can be treated as instances of their superclass
            - When you want to promote code by inheriting properties and behaviors from existing classes
            - When you want to leverage polymorphism allowing subclasses objects to be treated uniformly through their common superclass interface


    - WHY CHOOSE COMPOSITION OVER INHERITANCE:
        1. Tight coupling:
            - Inheritance create a strong coupling between the super and sub classes. Any changes made to the super can potentially affect the behaviour of all sub classes

        2. Limited Extensibility:
            - The Fragile-Base limits the extensibility of software systems, as modifications to the base class can become increasingly risky and costly over time. Developers may avoid making necessary changes due to the fear of breaking existing functionality -- Brittle software


    - FRAGILE-BASE CLASS:
        - Fragile-Base class is a software design issue that arises in object-oriented programming when changes made to a base class can advertently break the functionality of derived classes. This problem occurs due to the tight coupling between base and derived classes in inheritance hierarchies

        - PREVENTION STRATEGIES:
            - To mitigate the Fragile-Base Class problem, software developers can use design principle such as Open-Closed Principle and Dependency Inversion Principle, as well as design patterns like Composition over inheritance. These approaches promote loose coupling, encapsulation and moduler design, reducing the impact of changes in base classes

*/

public class Notes {
}
