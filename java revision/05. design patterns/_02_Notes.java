/*

    NOTES:
    - OOP principle
        - Encapsulation
            - Securing fields and only accesing them through method access modifiers
            - Example:
                - Bank details

        - Abstraction
            - Hiding internal implementations logic and only exposing what is required
            - Making one interface public and making all other private
            - Example:
                - Sending an email
                - Shopping in an ecormerce

        - Inheritance
            - Creating a subclass from a super class, this prevent duplication, increate code maintainability and enables polymorphism
            - sub-classes inherit super traits and can oveeride them methodsand fields too, sub-classes can have methods and fields of their own
            - Example: Car and Vehicle

        - Polymorphism
            - Is the ability of an object to exist in more than one form
            - Example: Vehicle behaving like Car, Boat, Ship

        - Composition
            - Refers to combination of several independent classes to form one and act as whole
            - The independent classes have methods and fields of their own
            - Car having Chassis, Engine, Wheel classes
            - The Car class delegates tasks to the independent classes rather than doing it on it's own

        - Coupling
            - Refers to the degree of dependency between classes
            - Low and high level dependency
            - OC and DI to help solve for high coupling
            - Composition over Inheirance
            - Fragile-base class
            - Brittle software


    - SOLID principle
        - Single Responsibility principle
            - States that a class should only one reason to change. By extension a class should only have one well defined objective/ task
            - Example:
                - [Bank -> BankTransation]
                - [User -> UserService]
                - [Student -> StudentProfile]

        - Open-closed principle
            - States that a software entity(class, module) should be open for extension but closed for modifications
            - Example:
                - Shape -> ShapeType enum -> if-else areaCalculation();

        - Liskov substitution principle
            - States that an Object of a super class should be replacable with it's subclasses without compromising the program correctness
            - Example:
                - Shape -> Rectangle -> Square;
                - Based on assumption that a square is a unique rectangle

        - Interface segregation principle
            - States that a clients should not be forced to implement interfaces they don't need
            - Example:
                - Circle, Sphere, area() volume()

        - Dependency inversion principle
            - State that high level module and low level module should not communicate directly, they both should implement abstraction
            - Example:
                - Car & Engine classes

        - Hidden Methods:
            - IllegalArgumentException();
            - UnsupportedOperationException();



    - Design patterns
        - 

        - Types:
            - Creational design pattern
                - Def: These are design pattern that focus on actual creation of objects while hiding interal implementation details

                - Examples:
                    - AbstractFactory
                    - Builder
                    - FactoryMethod
                    - prototype
                    - Singleton


            - Structural design pattern
                - Def: How Objects to relate to each other and work together to get done a task
                - Examples:
                    - Adapter
                    - Bridge
                    - Composite
                    - Decorator
                    - Facade
                    - Flyweight
                    - Proxy

            - Behavioural design pattern
                - Def: 
                - Examples:
                    - ChainOfResponsibility
                    - Command
                    - Interpreter
                    - Iterator
                    - Mediator
                    - Momento
                    - Observer
                    - State
                    - Stratergy
                    - Template
                    - Visitor

 */

public class _02_Notes {
}
