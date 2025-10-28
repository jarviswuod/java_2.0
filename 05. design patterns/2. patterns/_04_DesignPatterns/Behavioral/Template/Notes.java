package _04_DesignPatterns.Behavioral.Template;

/*

    NOTES:
    - Template pattern:
        - Is a behavioral pattern that allows you to define a template method or skeleton for an operation with specific steps implemented in subclasses


    - CHALLENGE:
        - Suppose we are designing some software that will be installed on a machine that makes hot beverages. At the beginning we have tea and coffee but, after some feedback from the customers, we needed to add some more beverages such as camomile tea

            __________________       __________________       __________________
            | Tea            |       | Coffee         |       | Camomile       |
            |________________|       |________________|       |________________|
            | makeBeverage() |       | makeBeverage() |       | makeBeverage() |
            |________________|       |________________|       |________________|

            - makeBeverage():
                - boilwater()       // same for all beverages
                - pourIntoCup()     // same for all beverages
                - brew()            // Differs
                - addcondiments()   // Differs


        - We started by making a separate class for each hot beverage. But as the number of beverages grow, we have lots of code duplication. We also have no way of ensuring that each class follows a particular structure meaning each client code is having lots of conditionals that pick the proper course of action depending on the particular beverage class



    -  SOLUTION 1: SOLVING WITH POLYMORPHISM; Strategy Pattern
        - By using polymorphism, we'll inadvertently used the Strategy Pattern
        - There are two good ways to solve the code duplication issue;
            - Polymorphism
            - Inheritance

                _____________________            ______________
                | BeverageMaker     |            | Beverage   |
                |___________________|<>--------->|____________|
                | prepareBeverage() |            | prepare(): |
                |___________________|            |____________|
                                                        ^
                                                        |
                                                        |
                                                 ______________
                                                 | Tea        |
                                                 |____________|-|
                                                 | prepare(): | |
                                                 |____________| |
                                                   |____________|

                - prepareBeverage():
                    - boilingWater()    // commom
                    - pourIntoCup()     // common
                    - beveragePrepare() // Unique


        - We provided a commom Beverage interface to force all beverages to follow a specific structure
        - We then have a BeverageMaker class that manages preparing different beverages
            - This class includes common operations for making all beverages, such as boiling water and pouring it into a cup, and also calls the specific operations to each delegated Beverage
            - Now when create a new beverage, we only have to include code unique to that beverage



    -  SOLUTION 2: SOLVING WITH INHERITANCE; Template method
        - This is the Template method pattern; Beverage class has template method that provides a common setup and structure for preparing a beverage
        - We can also solve this problem using inheritance; i.e Tea, Coffee and Camomile have things in common hence create an abstract Beverage class to implement the prepare() method. But, after we boiled the water and poured it into a cup, what happens next is unknown in the abstract Beverage class as it depends on the particular beverage
        - These beverage-specific steps will be determined later on, when Beverage class is extended

        - We provide a base abstract class called Beverage that contains all common operations for making a beverage, and we can provide methods, brew() and addCondiments(), which can be overriden in concrete classes

                                             ABSTRACT CLASS
                                         ________________________
                                         |  Beverage            |
                                         |______________________|           - prepare():
                                         |  + prepare()         |              - boilingWater()
                                         |  # brew()            |              - pourIntoCup()
                                         |  # addCondiments()   |              - brew()
                                         |______________________|              - addCondiments()
                                                    ^
                                                    |
                                                    |
                        ____________________________|__________________________
                        |                           |                         |
                _____________________     _____________________     _____________________
                |  Tea              |     |  Coffee           |     |  Camomile         |
                |___________________|     |___________________|     |___________________|
                | + brew()          |     | + brew()          |     | + brew()          |
                | + addCondiments() |     | + addCondiments() |     |___________________|
                |___________________|     |___________________|



    - TEMPLATE METHOD PATTERN UML: From GoF book:

                _______________________
                |  AbstractClass      |
                |_____________________|         - templateMethod():
                | + templateMethod(): |             # method1(): // Hook
                | # method1():        |             # method2(): // Hook
                | # method2():        |
                |_____________________|
                        ^
                        |
                        |
                __________________
                |  ConcreteClass |
                |________________|-|
                | # method1():   | |
                | # method2():   | |
                |________________| |
                  |________________|


        - We have an abstract class with a concrete implementation of the common/shared templateMethod(). The abstract methods will be implemented within the concrete classes can be used to alter the behaviour of the template methods

        - We can also give the primitive operations a default implementation and leave it up to the subclasses to either take them as they are, or override them. In this case, we refer to these methods as "hooks" or "hook operations"



    - Template Method vs Strategy Pattern
        - Template Method Pattern:
            - Use the Template Pattern when you have an algorithm with a fixed structure but with certain steps that need to be customized or implemented differently by subclasses
            - This pattern is ideal when you want to define a common algorithm skeleton(template method) in a base class and allow subclasses to selectively override specific steps to provide their own implementations
            - The Template Method Pattern is suitable when the overall algorithm structure remains consistent, but specific parts of the algorithm can vary based on different requirements or contexts


        - Strategy Pattern:
            - Use the Strategy Pattern when you want to define a family of interchangable algorithms or behaviours and encapsulate each algorithm into it's own class
            - This pattern is ideal when you need to dynamically select and switch between different algorithms at runtime, depending on the situation or context
            - The Strategy Pattern is suitable when you want to decouple the clients code from specific algorithm implementations, allowing greater flexibility and extensibility


        - In summary:
            - If you primarily need to customize or override specific steps of an algo while keeping the overall structure intact, then Template Method Pattern is a good choice
            - If you need to encapsulate entire algo or behaviors as interchangable components that can be dynamically selected or replaced, then Strategy Pattern is more appropriate

        - Both patterns have their own strengths and used to address different design scenarios. The choise between them depends on the specific requirements and design goals of your application



    - When to use Template method pattern:
        - When you want to allow clients to implement only particular steps in an algorithm and not the whole algorithm
        - It's good to use when you have a bunch of classes with the same logic, but with difference in a few steps. So if the algorithm changes it only has to be modified in one place - the base class



    - Pros and Cons:
        + Reduce code duplication
        + Clients are only allowed to modify certain steps in an algorithm, reducing the risk of breaking clients if the algorithm changes

        - Some clients may be limited by the provided template
        - Template methods can be hard to maintain if they have lots of steps

 */

public class Notes {

}
