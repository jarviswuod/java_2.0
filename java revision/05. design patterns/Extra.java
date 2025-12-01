/*

    NOTES:
    - Behavioural design pattern:
        - Visitor:
            - Allows algorithms to be separeted from the object they are operating/acting on
            - Key players:
                - Visitor interface
                - Concrete Visitor
                - Element interface
                - Concrete Element

            - Example:
                - PDF export, Marketing tips


        - Template Method:
            - Algorithm skeleton with specific implementations done at specific subclasses
            - Key players:
                - Super class
                - sub classes  

            - Example:
                - Template and Strategy pattern
                - 


        - Strategy:
            - A group of interchangable algorithms to be picked and used dynamically at runtime
            - Key players:
                - Context
                - Strategy interface
                - Concrete strategy

            - Example:
                - Beverage vendor


        - State:
            - Objects changes it's behaviour based on it's internal state chage
            - Key players:
                - Context
                - State interface
                - Concrete state 

            - Example:
                - Document Editor


        - Observer:
            - One to many relationship between objects, changes in one object is communicated and reflected in other objects
            - Key players:
                - Publisher
                - Subscriber
                - Subsystem 

            - Example:
                - SpreadSheet


        - Memento:
            - Internal state of object is captured and exported without affecting objects encapsulation
            - Key players:
                - Originator
                - Memento
                - Caretaker

            - Example:
                - Online editor, with history and undo redo capabilities


        - Mediator:
            - Multiple object internal changes communicated not direcly - via a bridge and they dont know of each other existance
            - Key players:
                - Mediator inteface
                - Concrete mediator
                - Element interface
                - Concrete element

            - Example:
                - UIControl: textbox, button, titlebox


        - Iterator:
            - Iteating through a collection objects without exposing internal state changes do not affect the client code
            - Key players:
                - Iterator interface
                - Concrete Iterator
                - Collection interface
                - Concrete Collection

            - Example:
                - Shopping list


        - Interpreter:
            - syntax, languae or formula interpretation
            - Key players:


        - Command:
            - Converts every request into an object with every info about the request 
            - Key players:
                - Command interface
                - Concrete Command
                - Component interface
                - Concrete component

            - Example:
                - Undo and Observer
                - HtmlEditor & RemoteControl


        - Chain of responsibility:
            - A group of objects which can either process a request or pass it along to the next object to process it
            - Key players:
                - Handler Interface
                - Concrete Handler

            - Example:
                - Logging into a system



    - Structural design pattern:
        - Proxy:
            - Introducing an object to control access to another object
            - Caching, Lazy loading, resource management, logging, access control
            - Key players:
                - Subject
                - Real subject
                - Proxy

            - Example:
                - YoutubeDownloadProxy


        - Flyweight:
            - Share the same state between multiple object for memory management
            - Key players:
                - Flyweight Factory
                - Flyweight Class
                - Object

            - Example:
                - Farm with Crop


        - Facade:
            - Simplify a complex object interface encapsulating complex and uncessary endpoints
            - Key players:
                - Facade interface
                - Concrete Facade
                - Subsystems classes

            - Example:
                - Processing an OrderRequest


        - Decorator:
            - Is a structural pattern that allows you to dynamically add behaviors or responsiblities to objects without changing their code
            - Is a structural patten that allows you to add behavious or responsibilities dynamically to an object without changing their code
            - Key players:
                - Decorator Interface
                - Concrete Decorator
                - Component interface
                - Concrete Component

            - Example:
                - Cloud Storage


        - Composite:
            - Is grouping a colletion of object into a tree like structures where the individual objects and and group of objects are treated in a unified manner
            - Key players:
                - Composite
                - Leaf
                - Component

            - Example:
                - Package delivery pricing


        - Bridge:
            - Separation of abstraction from implementation with each end growing independently
            - Key players:
                - Abstraction
                - Implementation interface
                - Concrete implementation

            - Example:
                - Remote Control; lg, sony, advanced


        - Adapter:
            - Bridging together incompatible object interfaces
            - Key players:
                - Target
                - Adapter
                - Adaptee

            - Example:
                - Color Selection



    - Creational design pattern:
        - 
        - 
        - 
        - 
        - 



*/

public class Extra {
}
