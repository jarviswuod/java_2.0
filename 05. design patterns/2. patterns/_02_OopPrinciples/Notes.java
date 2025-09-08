package _02_OopPrinciples;

/*

    NOTES:
    - Composition VS. Inheritance
        - When to use Composition:
            - When you need more flexibility in constructing objects by assembling smaller, reusable components
            - When there is no clear 'is-a' relationship between classes, and a 'has-a' relationship is more appropriate
            - When you want to avoid the limitation of inheritance, such as tight coupling and the fragile base class problem


        - When to use inheritance:
            - When there is a clear 'is-a' relationship between classes, and subclass objects can be treated as instances of their superclass
            - When you want to promote code by inheriting properties and behaviours from existing classes
            - When you want to leverage polymorphism to allow objects of different subclasses to be treated uniformly through their common superclass interface


    - Fragile Base class problem:
        - Fragine Base class problem is a software design issue that arises in object-oriented programming when changes made to a base class can advertently break the functionality of derived classes. This problem occurs due to the tight coupling between base and derived classes in inheritance hierachies

        - Why choose composition over Inheritance:
            1. Inheritance coupling:
                - Inheritance create a strong coupling between the super and sub. Any changes made to the super can potentially affect the behaviour of all sub classes

            2. Limited Extensibility:
                - The Fragile Base problem limites the extensibility of software systems, as modifications to the base class can become increasingly risky and costly over time. Developers may avoid making necessary changes due to the fear of breaking existing fucntionality -- Brittle software
            
        Prevention/ overcoming/ Mitigation Strategies:
            - To mitigate the Fragile Base Class problem, software developers can use design principle such as Open/ Closed Principle and dependency Inversion Principle, as well as design patterns like Composition over inheritance. These approaches promote loose coupling, encapsulation and moduler design, reducing the impact of changes in base classes

    - Unified Modeling Language:UML
        UML is a language used to model our systems/ the relationships between out classes.
        
        - Types of relationships:
            - Inheritance Relationship:
                - Represented by an arrow: The Dog inherits from, or extends, the Animal clas:
                    public class Dog extends Animal {
                        // Logic goes here
                    }

            - Composition Relationship:
                - Represented with a filled diamond
                    public class Dog {
                        private Size size;
                        // Rest of the logic
                    }

            - Association Relationship:
                - Represented by an arrow


            - Dependency Relationship: represented by a dashed arrow
                public class Dog {
                    public void render(Document document) {...}
                }



        - Difference between Association and Composition Relationship:
            - Association:
                - When a child object can still exist without it's other object class
                    - Example:
                        - A person has a Car, but is not composed of a Car.
                        - A person holds a reference to Car so it can interact with it, but a Person can exist without a Car.


            - Composition:
                - When a child object wouldn't be able to exist without it's parent object
                    - Example:
                        - A hotel is composed of it's rooms, and HotelBathroom cannot exist without Hotel(destory the hotel you destroy the hotel bathroom - it can't exist by itself)
                        - If a Customer is destroyed their SHippingCard and Orders are aso lost too, therefore Customer is composed of ShoppingCart and Orders.
                        - If Orders are lost, OrderDetails and ShippingInfo are lost, the orders are composed of shipingInfor and OrderDetails

*/

public class Notes {

}
