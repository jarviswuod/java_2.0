package _02_OOP_Principles;

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

*/

public class Notes {

}
