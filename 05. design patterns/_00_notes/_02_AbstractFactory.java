/*

    NOTES:
    - The Abstract Factory is a creation design pattern that provides an interface for creating families of related or dependent objects without specifying there concrete classes
    - It extends the concept of Factory Design pattern by introducing multiple Facotry methods organised into a single Factory class.
    - This pattern is especially useful when a system needs to be independent of how its objects are created, composed and represented

    - 4 Main actors in Abstract Factory;
        - Abstract Factory:
            - This is an interface that declears several factory methods, and is responsible for creating a family of related products

        - Concrete Facotry:
            - Is a subclass of abstract factory that implements factory methods create complete isntances of related products

        - Abstract Products and Concrete products
            - Concrete products is a subclass of abstract products, which is an interface that implements certain products features defined in abstract products


    - Advantages and Disadvantages
        - Advatanges:
            - Consistency: It promotes consistency by ensuring that products genrerated by the factory are compatible and consistent with each other
            - Separation of Responsibility: It enables the isolation of object creation, this means that client code remains isolated from the specifics of object creation contributing to high level of abstraction
            - Flexibility: It offers flexibility as you fcan easily introduce new product families by creating new concrete Factory classes without changing existing client code
            - Loose coupling: It encourages separation, Clients rely on the abstract interfaces of factories and products which reduces dependecy on concrete classes


        - Disadvatanges:
            - Complexity: It introduces increased complexity to the code base particularly when managing multiple factories and products families. As more type of product and factories are added, the number of classes and interactions can grow substantially potentially making the code hanrder to understand and maintain
            - Limited Scope: It's most suitalbe when dealing with a specific set of related product families. If the application requires creation of individual objects with unique chacteristcs, other creation patterns like Factory Method or Builder might be more appropriate

 */

public class _02_AbstractFactory {

}
