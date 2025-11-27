/*

    NOTES:
    - Behavioral design pattern:
        - Visitor
        - Template Method
        - Strategy
        - State
        - Observer
        - Mediator
        - Memento
        - Iterator
        - Interpreter
        - Command
        - Chain of responsibility


    - Structural design pattern:
        - Proxy
        - Flyweight
        - Facade
        - Decorator
        - Composite
        - Bridge
        - Adapter


    // -----------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------


    - Visitor pattern:
        - Is a behavioral pattern that separates an algorithm from an object on which it operates on
        - 4 Key players:
            - Visitor interface
            - Concrete Visitor
            - Element interface
            - Concrete Element

        - Example:
            - 


    - Template method pattern:
        - Is a behavioral pattern provides a skeleton of an algorithm for detailed implementation by subclasses extending the algos super class
        - 2 Key players:
            - Abstract class
            - Concrete classes

        - Example:
            - 


    - Strategy pattern:
        - Is a behavioral pattern that defines a family of related algorithms that can be swapped at runtime by an object
        - 3 Key players:
            - Context
            - Strategy interface
            - Concrete Strategy

        - Example:
            - 


    - State pattern:
        - Is a behavioral pattern that allows an object to change it's behavior when it's internal state changes
        - 3 Key players:
            - Context
            - State interface
            - Concrete State

        - Example:
            - 


    - Observer pattern:
        - Is a behavioral pattern that defines a one to many relationship between objects and changes in one object is automatically communicated and reflected in other objects
        - 3 Key players:
            - publisher
            - subscriber
            - Concrete subscriber

        - Example:
            - 


    - Memento pattern:
        - Is a behavioral pattern that enables us capture and externalizes the internals of an object without affecting the objects encapsulation
        - 3 Key players:
            - Originator
            - memento
            - Caretaker

        - Example:
            - 


    - Mediator pattern:
        - Is a behavioral pattern that provides a communication mechanism when objects via a bridge without the objects necessasirly knowing of each other existence
        - 4 Key players:
            - Mediator interface
            - Concrete Mediator
            - Component interface
            - Concrete Component

        - Example:
            - 


    - Iterator pattern:
        - Is a behavioral pattern that provides a mechanism for iterating over objects without exposing the object internal structure plus changing the internals doesnot break the client code
        - 4 Key players:
            - Iterator interface
            - Concrete Iterator
            - Collection interface
            - Concrete Collection

        - Example:
            - 


    - Interpreter pattern:
        - Is a behavioral pattern that provides a mechanism for interprets language, formula or expression
        - 0 Key players:
            - 

        - Example:
            -


    - Command pattern:
        - Is a behavioral pattern that converts request to an object containing every information about the request
        - 4 Key players:
            - Command interface
            - Concrete Command
            - Invoker
            - Receiver

        - Example:
            - 


    - Chain of Responsibility pattern:
        - Is a behavioral pattern that allows you to create a chain of objects where each object can either handle a request or pass it along to the next object
        - 2 Key players:
            - Handler interface
            - Concrete Handler

        - Example:
            - 

    // -----------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------



    - Proxy pattern:
        - Is a structural pattern that
        - 4 Key players:
            - Visitor interface
            - Concrete Visitor
            - Element interface
            - Concrete Element

        - Example:
            - 


    - Flyweight pattern:
        - Is a structural pattern that
        - 4 Key players:
            - Visitor interface
            - Concrete Visitor
            - Element interface
            - Concrete Element

        - Example:
            - 


    - Facade pattern:
        - Is a structural pattern that
        - 4 Key players:
            - Visitor interface
            - Concrete Visitor
            - Element interface
            - Concrete Element

        - Example:
            - 


    - Decorator pattern:
        - Is a structural pattern that
        - 4 Key players:
            - Visitor interface
            - Concrete Visitor
            - Element interface
            - Concrete Element

        - Example:
            - 


    - Composite pattern:
        - Is a structural pattern that
        - 4 Key players:
            - Visitor interface
            - Concrete Visitor
            - Element interface
            - Concrete Element

        - Example:
            - 


    - Bridge pattern:
        - Is a structural pattern that
        - 4 Key players:
            - Visitor interface
            - Concrete Visitor
            - Element interface
            - Concrete Element

        - Example:
            - 


    - Adapter pattern:
        - Is a structural pattern that
        - 4 Key players:
            - Visitor interface
            - Concrete Visitor
            - Element interface
            - Concrete Element

        - Example:
            - 


    SECOND DRAFT REVISION::: ::: :::

            Behavioral design pattern:
            - Visitor
                - Is a behavioral pattern that separates the algorithm from the object it's acting/ working on
                - Key players
                    - Visitor interface
                    - Concrete visitor
                    - Element interface
                    - Concrete Element
                - Example:
                    - SendMail & ExportPDF


            - Template method
                - Is a behavioral pattern that provides an algorithm skeleton with specific algo details implemented by sub-classes
                - Key players
                    - Abstract class
                    - Concrete class
                - Example:
                    - Beverage maker
                    - Strategy & template method


            - Strategy
                - Is a behavioral pattern that defines a family of interchangeable algorithms that can be swapped at runtime
                - Key players
                    - Context
                    - Strategy interface
                    - Concrete strategy
                - Example:
                    - Video Editor [compressing and colors]


            - State
                - Is a behavioral pattern where an objects behavior changes with changes in internal object state
                - Key players
                    - Context
                    - State interface
                    - Concrete state
                - Example:
                    - UserRole and Doc


            - Observer
                - Is a behavioral pattern that defines a one to many relationship between object, changes in one object is automatically reflected in other objects
                - Key players
                    - Publisher
                    - Subscriber interface
                    - Concrete Subscriber
                - Example:
                    - Datasource


            - Memento
                - Is a behavioral pattern that captures and exports internal states of an object without affecting it's encapsulation
                - Key players
                    - Originator
                    - Memento
                    - Caretaker
                - Example:
                    - Text Editor with title and detail


            - Mediator
                - Is a behavioral pattern that provides a communication channel between different objects without the objects being aware of each other
                - Key players
                    - Mediator interface
                    - Concrete Mediator
                    - Component interface
                    - Concrete component
                - Example:
                    - Text Editor: textbox, title, button
                    - Mediator & Mediator with Observer pattern


            - Iterator
                - Is a behavioral pattern that provides a way to iterate over a group of objects without exposing it's internals and change in collection does not affect the client code
                - Key players
                    - Iterator interface
                    - Concrete iterator
                    - Collection interface
                    - Concrete collection
                - Example:
                    - Shopping List


            - Interpreter

            - Command
                - Is a behavioral pattern that converts a request into an object with containing all information about the request
                - Key players
                    - Command interface
                    - Concrete command
                    - Invoker
                    - Receiver
                - Example:
                    - Remote Control class
                    - Undo -> HTML Doc Editor


            - Chain of responsibility
                - Is a behavioral pattern that defines a group of objects where a request can be processed by an object or just passed onto the next object for processing
                - Key players
                    - Handler interface
                    - Concrete Handler
                - Example:
                    - Website entrace -> validation ... logging



            Structural design pattern:
            - Proxy
                - Is a structural pattern that provides an object to control access to another object
                - Key players
                    - Subject
                    - Real subject
                    - Proxy
                - Example:
                    - YoutubeVideoProxy


            - Flyweight
                - Is a structural pattern aimed at sharing same state between multiple objects to minimize memory usage
                - Key players
                    - Context
                    - Flyweight
                    - FlyweightFactory
                - Example:
                    - Farming game: CropIcon


            - Facade
                - Is a structural pattern that privides a simplified interface to a complex system to help encapsulate the complexities and improve the usability
                - Key players
                    - Facade interface
                    - Concrete Facade
                    - Subsystem classes
                - Example:
                    - Order Request


            - Decorator
                - Is a structural pattern that allows you to dynamically add behaviors or responsibilities to objects without changing their code
                - Key players
                    - Decorator interface
                    - Concrete Decorator
                    - Component interface
                    - Concrete Component
                - Example:
                    - Data storage: Encryption, Compression, Validation


            - Composite
                - Is a structural pattern that enables you to creation of tree-like structure to represent collections of objects where both individual objects and groups of objects are treated  in a unified manner
                - Key players
                    - Component
                    - Leaf
                    - Composite
                - Example:
                    - Delivery package pricing


            - Bridge
                - Is a structural pattern that separates abstraction from implementation allowing them to evolve independently
                - Key players
                    - Abstraction
                    - Implementation
                    - Concrete Implementation
                - Example:
                    - Remote Control and Electronic device


            - Adapter
                - Is a structural pattern that allow object with incompatible interfaces to work together by providing a bridge between them
                - Key players
                    - Target
                    - Adaptee
                    - Adapter
                - Example:
                    - 3rd party color library to video editor


*/

public class SummaryNotes {

}
