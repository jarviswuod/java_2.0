package _04_DesignPatterns.Creational.FactoryMethod;

/*

    NOTES:
    - Factory design pattern:
        - Is a creational pattern that defines an interface for creating objects, but allows subclasses to alter the type of objects that will be created, providing a way to delegate the instantiation logic to subclasses, enabling flexibility in object creation without changing the client code


    - CHALLENGE:
        - Say that we are developing a new Model-View-Controller backend framework, to rival the popular PHP framework, Laravel



    - SOLUTION : Factory Method
        - We can add a createViewEngine() factory method in the Controller class. By default, we return the Blade view engine. But if the developer wants to switch to a different view engine, such as Twig, then they can use our alternative controller class, TwigController, that overrides the createViewEngine() Factory method;

                ________________________
                |  Controller          |
                |______________________|
                | + render()           |
                | # createViewEngine() |
                |______________________|
                            ^
                            |
                            |
                            |
                ________________________
                |  TwigController      |
                |______________________|
                | # createViewEngine() |
                |______________________|

            Controller.createViewEngine()
                - By default this returns a new BladeViewEngine()

            TwigController.createViewEngine()
                - Returns TwigViewEngine()



    - FACTORY PATTERN UML: From GoF book:
                ___________________
                |  Creator        |
                |_________________|
                | operation()     |
                | factoryMethod() |
                |_________________|
                        ^
                        |
                        |
                        |
                _____________________
                |  ConcreteCreator  |
                |___________________|-|
                | factoryMethod()   | |-|
                |___________________| | |
                  |___________________| |
                    |___________________|


                - operation()
                    Creator product = factoryMethod();

                - factoryMethod()
                    return new factoryMethod();


        - The objects returned from the Factory methods are referred to as "products"
        - The Factory Method Pattern is often misunderstood. It relies on inheritance and polymorphism to add flexibility to the design. Inheritance allows methods to be overriden in subclasses, and polymorphism allows different objects to be returned from the overriden methods

        - Many people implement the Factory Method Pattern incorrectly, e.g using a static method, such as;
                var engine =  ViewEngineFactory.createViewEngine();

        - But static methods cannot be overriden so there is no flexibility with this approach, and it isn't correct. We cannot change the implementation of the createViewEngine() method
        - Using the Factory method pattern, we can defer the creation of an object to subclasses, and this is possible through inheritance

 */

public class Notes {

}
