package _04_DesignPatterns.Creational.AbstractFactory;

/*

    NOTES:
    - Abstract Factory Pattern:
        - Is a creational design pattern that provides an interface for creating families of related objects without specifying their concrete classes, promoting encapsulation and allowing for the creation of object families that can vary independently



    - CHALLENGE:
        - Say that you have an app for Windows and Mac. The UI components - such as buttons, checkboxes and textboxes are different for each OS, but each type of UI component will have the same behaviours e.g a checkbox will have an onSelect() method
        - So, our app needs a way of knowing what the current OS is, and then select the appropriate family of UI components for that OS


    - SOLUTION: Abstract Factory Pattern:
        - Create an abstract factory class to create families of UI components, such as the family of Windows aUI components

                                    _______________________
                                    | UIComponentFactory  |
                                    |_____________________|
                                    | createButton()      |
                                    | createCheckbox()    |
                                    |_____________________|
                                               ^
                                               |
                                               |
                           ____________________|_________________________
                           |                                            |
                           |                                            |
                _________________________                _____________________________
                | MacUIComponentFactory |                | WindowsUIComponentFactory |
                |_______________________|                |___________________________|
                | createButton()        |                | createButton()            |
                | createCheckbox()      |                | createCheckbox()          |
                |_______________________|                |___________________________|



    - ABSTRACT FATORY PATTERN UML: From GoF book:

                                    _____________________
                                    | AbstractFactory   |
                                    |___________________|
                                    | createProductA()  |
                                    | createProductB()  |
                                    |___________________|
                                               ^
                                               |
                                               |
                                               |
                                    ______________________
                                    | ConcreteFactories  |
                                    |____________________|
                                    | createProductA()   |
                                    | createProductB()   |
                                    |____________________|

 */

public class Notes {

}
