/*

    NOTES:
    - Behavioral design pattern:
        - Visitor:
            - Separating algorithms from objects they are acting on
            - Key players:
                - Visitor inteface
                - Concrete Visitor
                - Element inteface
                - Concrete Element
            - Example:
                - PDF and Email marketing

        - Template:
            - A skeleton algorithm where specifics are implemented by subclasses
            - Key players:
                - Abstract class
                - Concrete class
            - Example:
                - Beverage

        - Strategy:
            - A collection of interchangeable algos used dynamically at runtime
            - Key players:
                - Context
                - Strategy interface
                - Concrete strategy
            - Example:
                - Video Editor with compression and Overlay

        - State:
            - Changing object behavior based on internal object state changes
            - Key players:
                - Context
                - State interface
                - Concrete state
            - Example:
                - Document and User enum class

        - Observer:
            - One to many relationship between objects, chnage in one is reflected in others
            - Key players:
                - Publisher
                - Subscriber interface
                - Concrete subscriber
            - Example:
                - Spreadsheet, Barchart staff

        - Memento:
            - Capture and export internal state of an object without affecting encapsulation
            - Key players:
                - Orignator
                - Memento
                - Carataker
            - Example:
                - Online Editor - Editstate

        - Mediator:
            - Using an object as a bridge of communication for other objects without them knowing of each other
            - Key players:
                - Mediator interface
                - Concrete Mediator
                - Element interface
                - Concrete Element
            - Example:
                - UIControls; button, title, box

        - Interpretor:
            - syntax, diagram or formula in a language
            - Key players:
                - 
            - Example:
                - 

        - Iterator:
            - Iterating over a collection of objects without affecting logic when changes happen to object internals
            - Key players:
                - Iterator interface
                - Concrete iterator
                - Collection interface
                - Concrete collection
            - Example:
                - Shoppinglist price

        - Command:
            - Convert request into an object with all request infor
            - Key players:
                - Command interface
                - Concrete Command
                - Invoker
                - Receiver
            - Example:
                - undo & Observer HTML Editor
                - LightOn, LightOff, LightDim

        - Chain of Responsibility:
            - Chaining a group of objects and either processing or passing a request to the next object in chain
            - Key players:
                - Object interface
                - Concrete Object
            - Example:
                - Logging into a system


    - Structural design pattern:
        - Proxy:
            - Introducing an object to control access to another object
            - Key players:
                - Subject
                - Real subject
                - Proxy
            - Example:
                - YoutubeDownaloaderAPI

        - Flyweight:
            - Shared object states between multiple objects to save on memory
            - Key players:
                - Flyweight Factory
                - Flyweight Class
                - 
            - Example:
                - Farm and icons

        - Facade:
            - Simplifing complex object interfaces, encapsulating complexities and uncessary endpoint
            - Key players:
                - Facade interface
                - Concrete Facade
                - Objects
            - Example:
                - Order request processing

        - Decorator:
            - Allows additional of algorithm or behaviors to an object dynamically
            - Key players:
                - Decorator interface
                - Concrete Decorator
                - Component interface
                - Concrete Component
            - Example:
                - Cloud Storage

        - Composite:
            - Tree-like representation of object collection
            - Key players:
                - Component
                - Leaf
                - Composite
            - Example:
                - Order items

        - Bridge:
            - Separation between abstraction and implementation, both grow independently
            - Key players:
                - Abstraction
                - Implementation
                - Concrete implementation
            - Example:
                - Remote Control; TV and Radio

        - Adapter
            - Pattern that makes it possible for different object interface interact
            - Key players:
                - Target
                - Adapter
                - Adaptee
            - Example:
                - VideoEditor & Color

*/

public class _04_Notes {

}
