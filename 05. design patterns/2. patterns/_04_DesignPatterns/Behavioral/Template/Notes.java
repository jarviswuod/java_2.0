package _04_DesignPatterns.Behavioral.Template;

/*

    NOTES:
    - The template pattern allows you to define a template method, or skeleton, for an operation. The specific steps can then be implemented in subclasses

    - Suppose we are desinging some software that will be isntalled on a machine that makes hot beverages. At the beggining we jsut had tea and coffee. But after some fedback from the customers, we needed to add some more beverages, cush as camomile tea

                _____________________                 _____________________                 _____________________
                |  Tea              |                 |  Coffee           |                 |  Camomile         |
                |___________________|                 |___________________|                 |___________________|
                | makeBeverage()    |                 | makeBeverage()    |                 | makeBeverage()    |
                |___________________|                 |___________________|                 |___________________|

            - Make beverage:
                - boilwater()       // same for all beverages
                - pourIntoCup()     // same for all beverages
                - brew()            // Differs
                - addcondiments()   // Differs

    - We started out simple, making a separate class for each hot beverage. But as the number of beverages grows, we see a lot of code duplication. We also have no way of ensuring that each class follows a particular structure, which mean that the client code will have lots of class follow a particlular structure, which mean that the client code will have lots of conditionals that pick the propoer course of action depending on the particular beverage class

    - There are two good ways to solve the code duplication issue;
        - Polymophism
        - Inheritance


                ________________________            ___________________
                |  BeverageMaker       |            |  Beverage       |
                |______________________|<>--------->|_________________|
                |  + prepareBeverage() |            | + prepare():    |
                |______________________|            |_________________|
                                                           ^
                                                           |
                                                           |
                                                    _________________
                                                    |  Tea          |
                                                    |_______________|-|
                                                    |  + prepare(): | |
                                                    |_______________| |
                                                      |_______________|


    - prepareBeverage():
        - boilingWater()    // commom
        - pourIntoCup()     // common
        - beveragePrepare() // Unique
    - By using polymorphism, we have inadvertently used the Stratergy Pattern

    - We provided a commom Beverage interface to force all beverages to follow a specific strcutre. We then have a BeverageMaker class that manages preparing different btwn different beverages.
    - THis class includes the commo operations for making all beverages, such as boiling water and pouring it into a cup, and also calls the operations specific to each beverage, which is delegated to Beverage. Now when create a new beverage, we only have to include code unique to that beverage


    -  SOLVING WITH INHERITANCE:
        - We can also solve this problem using inhertance:

            - Tea, Coffee and Camomile have things in common, so we can create an abstract Beverage class to implement the prepare() method. But, after we boiled the water and poured it into a cup, what happens next is unknown in the abstract Beverage class, as it depends on the particular beverage. 
            - These beverage-specific steps will be determined later on, when Beverage class is extended

            - We can provide a base abstract class called Beverage that contains all common operations for making a beverage, and we can provide methods, brew() and addCondiments(), which can be overriden in concrete classes

                                                        ABSTRACT CLASS
                                                    ________________________
                                                    |  Beverage            |
                                                    |______________________|
                                                    |  + prepare()         |
                                                    |  # brew()            |
                                                    |  # addCondiments()   |
                                                    |______________________|
                                                            ^
                                                            |
                                                            |
                        _______________________________________________________________________
                        |                                   |                                 |
                        |                                   |                                 |
                _____________________             _____________________             _____________________
                |  Tea              |             |  Coffee           |             |  Camomile         |
                |___________________|             |___________________|             |___________________|
                | + brew()          |             | + brew()          |             | + brew()          |
                | + addCondiments() |             | + addCondiments() |             |___________________|
                |___________________|             |___________________|


            - The +Template method":
                - prepare():
                    - boilingWater()
                    - pourIntoCup()
                    - brew()
                    - addCondiments()

        - This is the Template method pattern; the Beverage class has template method that provides the common setup and struture  for prepareing a beverage

        - Template Method Pattern in GoF Book

                            _______________________
                            |  AbstractClass      |
                            |_____________________|
                            | + templateMethod(): |
                            | # method1():        |
                            | # method2():        |
                            |_____________________|
                                    ^
                                    |
                                    |
                            ______________________
                            |  ConcreteClass     |
                            |____________________|-|
                            | # method1():       | |
                            | # method2():       | |
                            |____________________| |
                              |____________________| 

        - templateMethod():
            # method1(): // Hook
            # method2(): // Hook
    
        - We have an abract class with a concrete implementation of the common/shared templateMethos(). The abstract methods that will be implemented within the concrete classes can be sued to alter the behaviour of the template methos

        - We can also give the primitive operations a default implmentation and leave it up to the subclasses to either take them as they are, or override them. In this case, we refer to these methods as "hooks" or "hook operations"

        - Template Method vs Strategy Pattern
            - Template Method Pattern:
                - Use the Template Pattern when you have an algorithm with a fixed structure but with certain steps that need to be customized or implemented differently by subclasses
                - This pattern is ideal when you want to define a common algorithm skeleton(template method) in a base class and allow subclasses to selectively override specific steps to provide there own implementations
                - The Template Method Pattern is suitable when the overall algorithm structure remains consisitent, but specific parts of the algorithm can vary based on different requirements or contexts


            - Strategy Pattern:
                - Use the Strategy Pattern when you want to define a family of interchangable algoriths or behaviours and encapualte each algo ito its own class
                - THis pattern is ideal when you need to dynamically select and switch between different algos at runtime, depending on the situaltion or context
                - The Strategy Pattern is suitable when you want to decouple the clients code from secific algo implementations, allowing greather flexibility and extensibility

            - In summary:
                - If you primaryly need to customize or override specific steps of an algo while keeping the overrall strcture intact, then Template Method Pattern is a good choice
                - If you need to encpauslate entire algo or behavious as interchangable componenets that can be dynamically selected or replaced, then Strategy Patten is more appropriate

            - Both patterns have their own strengths and used to address different design scehnarios. The choise between them depends on the specific requirements and design goals of your application


        - WHen to use THE TEMPLATE METHOD PATTERN:
            - Use the Template Method Patten when you want to allow clients to implement only particular steps in an algo, and not the whole also
            - It's good to use when yoy have a bunch of classes with the same logic, or also, but with difference in a few steps. So if the algo changes it only has to be modified in one place - the base class

        - Pros and Cons:
            + Reduce code duplication
            + Clients are only allowed to modify certain steps in an algo, reducing the risk of breaking cleitns if the algo changes

            - Some clients may be limited by the provided template
            - Template methods can be hard to maintain if they have lots of steps

 */

public class Notes {

}
