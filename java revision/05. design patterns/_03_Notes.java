/*

    NOTES:
    - Intro
        - Oop concepts
        - Solid princples
        - Design patterns
            - Creational pattern
            - Structural pattern
            - Behavioral pattern



    - Deep dive:
        - Oop concepts
            - Encapsulation
            - Abstraction
            - Inheritance
            - Polymorphism
            - Coupling
            - Composition

        - Solid principles
            - Single responsibility
            - Open-closed principle
            - Liskov substitution
            - Interface segregation
            - Dependency inversion

        - Design pattern:
            - Behavioral pattern:
                - Visitor
                - Template Method
                - Strategy
                - State


    - Oop concepts:
        - Encapsulation:
            - No direct access to class fields, access is done via methods by use of access modifiers with verified business logic
            - Example:
                - Bank account

        - Abstraction:
            - Internal business logic implementation is off the offer interface, Only required interface is given to the user
            - Example:
                - Sending an email
                - Placing an order

        - Inheritance:
            - Super class provides the skeleton while child are extending parent and can override and implement there own methods
            - Example:
                - Vehicle and Cars
                - Animals
                - Users and Students
                - Students and Officials

        - Polymorphism:
            - Ability of an object to exist in more than one state
            - Vehicle and Car
                - List<Vehicle> list = List.of(new Car(), new Vehicle());

        - Coupling:
            - Is the degree by which separate classes depend on one another to accomplish a task
            - Low and High coupling
            - Caused by Inheritance

        - Composition:
            - The combination of several small independent classes to form a larger system which is flexible and maintanable
            - Sending an email and when sending an order

        - Random keywords:
            - Brittle software
            - Flagile class base
            - Go for composition over inheritance


    - SOLID principle:
        - Single Responsibility principle:
            - States that a software entity should have only one reason to change. This means that a class should only have one purpose
            - Example:
                - User and UserService
                - Student and Profile

        - Open-closed principle:
            - States that a class should be open for extension but closed for modifications
            - Example:
                - Shapes and calculatearea

        - Liskov substitution principle:
            - States that a super class should be substitutable with all it's sub-classes without affecting the program correctness
            - Example:
                - Shape - Rectangle - Square

        - Interface segregation principle:
            - States that an interface should not be forced to implement a method/algo it does not need
            - Example:
                - Circle - Sphere - volume() and area()

        - Dependency inversion principle:
            - States that high level module and low level modules should not communicate directly instead they should use abstraction
            - Example:
                - Order notification

    - Design pattern:
        - Visitor:
            - Is a behavioral pattern that separates an algorithm from class itself

            - 4 Key players:
                - Element
                - Concrete Element
                - Visitor
                - Concrete Visitor

        - Template Method:
            - Is a behavioral pattern where a super class provides a skeleton of an algo and subclasses implement them

            - 2 Key players:
                - Abstract class
                - Concrete class

            - 2 approaches:
                - Template method
                - Strategy method

            - Example:
                - Vending machine


        - Strategy:
            - Is a behavioral pattern that introduces a family of related algorithm that can be selected and used dynamically at runtime

            - 3 Key players:
                - Context
                - Strategy
                - Concrete Strategy

        - State:
            - Is a behavioral pattern that changes an object behavior with change in internal implementation state

            - 3 Key players:
                - Context
                - State
                - Concrete State


 */

public class _03_Notes {

}
