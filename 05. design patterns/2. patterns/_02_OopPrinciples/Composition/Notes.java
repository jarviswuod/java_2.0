package _02_OopPrinciples.Composition;

/*

    NOTES:
    - Composition;
        - Composition involves creating complex objects by combining simpler objects or components.
        - In composition, objects are assembled together to form large strctures, with each component object maintaining it's own state and behaviour
        - Composition is often described in terms of a 'has-a' relationship


    - GOOD CODE EXPLANATION:
        - In this example we have a load of items/parts that make up example a chassis, Wheels, Engine. All this an individual and complete Objects on their own(can contain both fields and complete methods)
                public class Chassis {
                    public void support() {...}
                }

                public class Engine {
                    public void start() {...}
                }

                public class Wheels {
                    public void rotate() {...}
                }

        - All this are parts that a Car is compose of. Under the Car class we see that the Car uses composition of all the individual classes above. The car class basically uses composition to assemble it's componenets, with each componenet being a separate class that does an independet role

                public class Car {

                    private Engine engine = new Engine();
                    private Wheels wheels = new Wheels();
                    private Chassis chassis = new Chassis();
                    private Seats seats = new Seats();

                    ...
                    ...
                }
                
        - A Car uses all this instances of the compnenents to delegate tasks to them inside the startCar() method rather than doing all that work itself

                public void startCar() {
                    engine.start();
                    wheels.rotate();
                    chassis.support();
                    seats.sit();
                    System.out.println("Car started");
                }
                
        - All we have to do is to create a Car instances and call the startCar() method and every componenet will be delegated it's designated role and the car starts

                public class Main {
                    public static void main(String[] args) {

                        Car car = new Car();
                        car.startCar();
                    }
                }

    - COMPOSITION VS. INHERITANCE:
        - When to use Composition:
            - When you need more flexibility in constructing objects by assembling smaller, reusable components
            - When there is no clear 'is-a' relationship between classes, and a 'has-a' relationship is more appropriate
            - When you want to avoid the limitation of inheritance, such as tight coupling and the Fragile-Base class problem


        - When to use inheritance:
            - When there is a clear 'is-a' relationship between classes, and subclass objects can be treated as instances of their superclass
            - When you want to promote code by inheriting properties and behaviours from existing classes
            - When you want to leverage polymorphism to allow objects of different subclasses to be treated uniformly through their common superclass interface


    - Fragile-Base class problem:
        - Fragine Base class problem is a software design issue that arises in object-oriented programming when changes made to a base class can advertently break the functionality of derived classes. This problem occurs due to the tight coupling between base and derived classes in inheritance hierarchies

        - Why choose composition over Inheritance:
            1. Inheritance coupling:
                - Inheritance create a strong coupling between the super and sub. Any changes made to the super can potentially affect the behaviour of all sub classes

            2. Limited Extensibility:
                - The Fragile-Base problem limites the extensibility of software systems, as modifications to the base class can become increasingly risky and costly over time. Developers may avoid making necessary changes due to the fear of breaking existing fucntionality -- Brittle software
            
        Prevention/ overcoming/ Mitigation Strategies:
            - To mitigate the Fragile-Base Class problem, software developers can use design principle such as Open/ Closed Principle and dependency Inversion Principle, as well as design patterns like Composition over inheritance. These approaches promote loose coupling, encapsulation and moduler design, reducing the impact of changes in base classes


*/

public class Notes {
}
