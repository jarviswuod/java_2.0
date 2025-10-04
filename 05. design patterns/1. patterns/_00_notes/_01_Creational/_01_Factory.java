package _01_Creational;

/*

    NOTES:
    - Factory method:
        - Is a creational design pattern used to create objects using the super class, allowing the super classes to alter the type of objects they create
        - It provides an interface for creating instances of your class but delegates the responsibility of creating instances to it's sub classes
        - This pattern is used to provide loose coupling and flexibility when creating objects


    - 4 Main actors in Factory;
        a. Factory
            - It's an interface that declares a factory method.It's responsible for creating objects of a particular type

        b. Concrete Factory
            - Is a subclass of a factory that implements a factory method for instantiating concrete product classes

        c. Product
            - Is the interface that defines methods for objects created by a factory method

        d. Concrete Product
            - This is a product subclass that implements the specific functions of the created objects


    - Advantages and Disadvantages
        - Advantages:
            - Flexibility: to introduce new types of products without changing with the existing client code
            - Weak coupling: It reduces the coupling between client code and concrete implementations providing loose coupling because clients depend on the factory interface ranter than the concrete classes
            - Separation of Responsibility: The method separates object creation from the rest of the code making it easier to manage changes to the object creation logic

        - Disadvantages:
            - Complexity: Creating separate concrete Factory classes for each object type can result in more classes and potentially more complex relationships between them
            - Code duplication: If creating logic for multiple products is similar you may end up duplicating code across implementations of a particular factory

 */

public class _01_Factory {

}
