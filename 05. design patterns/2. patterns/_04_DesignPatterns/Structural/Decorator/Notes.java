package _04_DesignPatterns.Structural.Decorator;

/*

    NOTES:
    - Decorator pattern:
        - Is a structural design pattern that allows behavior to be added to individual objects dynamically, enhancing functionality without altering the object's structure, and it's used to extend or modify the behaviour of objects by wrapping them with additional functionality through composition


    - CHALLENGE:
        - Say that we have an application that allows users to store data in the cloud. The data can be sent to the cloud as it is, without any processing, and it can also be compressed and/or encrypted before it's saved to the cloud

                                     __________________
                                     | CloudData      |
                                     |________________|
                                     | url            |
                                     |________________|
                                     | cloudData(url) |
                                     | save(data)     |
                                     |________________|
                                              ^
                                              |
                        ______________________|______________________________
                        |                     |                             |
                        |                     |                             |
                  _______________         ________________         ___________________________
                  | Encryption  |         | Compression  |         | Encryption&Compression  |
                  |_____________|         |______________|         |_________________________|
                  | save(data)  |         | save(data)   |         | save(data)              |
                  |_____________|         |______________|         |_________________________|

        - So far, everything looks OK. But if we need to create a new validation class to validate and clean the data before it is sent to the cloud. Our code starts to look bloated as we need to make lots of new classes just to add an extra feature

                                     __________________
                                     | CloudData      |
                                     |________________|
                                     | url            |
                                     |________________|
                                     | cloudData(url) |
                                     | save(data)     |
                                     |________________|
                                              ^
                                              |
                        ______________________|______________________________________________________________
                        |          |          |             |                |                    |         |
                        |          |          |             |                |                    |         |
                  _______________  |      ________________  |       ___________________________   |      ______________
                  | Encryption  |  |      | Compression  |  |       | Encryption&Compression  |   |      | Validation |
                  |_____________|  |      |______________|  |       |_________________________|   |      |____________|
                  | save(data)  |  |      | save(data)   |  |       | save(data)              |   |      | save(data) |
                  |_____________|  |      |______________|  |       |_________________________|   |      |____________|
                                   |                        |                                     |
                                   |                        |                                     |
               ___________________________     ___________________________         ______________________________________
               | Encryption&Validation   |     | Compression&Validation  |         | Encryption&Compression&Validation  |
               |_________________________|     |_________________________|         |____________________________________|
               | save(data)              |     | save(data)              |         | save(data)                         |
               |_________________________|     |_________________________|         |____________________________________|


        - To add one more feature, we have to create four new classes. Our class library is growing exponentially - not good, not maintanable, not flexible



    - SOLUTION 2: DECORATOR;
        - You may have noticed by this point that a lof of design patterns are based on moving away from inheritance and towards composition. With composition, one object has reference to another object, and delegates it some work. This allows you to use polymorphism and switch between objects at runtime, making your code flexible. Whereas with inheritance, the object itself is able to do the work, inheriting the behaviour from it's superclass. With inheritance we have to create lots of new classes; with composition, we can wrap, or decorate, existing objects to add new functionality

                                       ________________
                                       | Data         |<------------------------|
                                       |______________|                         |
                                       | save(data)   |                         |
                                       |______________|                         |
                                              ^                                 |
                                              |                                 |
                            __________________|_________________                |
                            |                                  |                |
                            |                                  |                |
                        __________________       __________________________     |
                        | CloudData      |       | DataDecorator          |     |
                        |________________|       |________________________|<>---|
                        | url            |       | wrappee: Data          |
                        |________________|       |________________________|
                        | cloudData(url) |       | dataDecorator(wrappee) |
                        | save(data)     |       | save(data)             |
                        |________________|       |________________________|
                                                               ^                   
                                                               |                   
                                             __________________|_________________  
                                             |                                  |  
                                             |                                  |  
                                    ________________________         _________________________ 
                                    | EncryptionDecorator  |         | CompressionDecorator  | 
                                    |______________________|         |_______________________| 
                                    | save(data)           |         | save(data)            | 
                                    |______________________|         |_______________________| 


            - Above, we make the encryption and compression objects decorators, because they are decorating the CloudData object with some additional behaviour. Because decorator classes have some common logic - e.g. referencing a CloudData object - We have created a DataDecorator class where this logic can be inherited to prevent code repetition

            - Our decorator classes are composed of( or are decorating/wrapping) a CloudData object(or any object that implements the Data interface)



    - DECORATOR PATTERN UML: From GoF book:

                                       ________________
                                       | Component    |<------------------------|
                                       |______________|                         |
                                       | execute()    |                         |
                                       |______________|                         |
                                              ^                                 |
                                              |                                 |
                            __________________|_________________                |
                            |                                  |                |
                            |                                  |                |
                        _____________________    __________________________     |
                        | ConcreteComponent |    | BaseDecorator          |     |
                        |___________________|    |________________________|<>---|
                        | execute()         |    | wrappee: Component     |
                        |___________________|    |________________________|
                                                 | baseDecorator(wrappee) |
                                                 | execute()              |
                                                 |________________________|
                                                               ^
                                                               |
                                                               |
                                                  _______________________ 
                                                  | ConcreteDecorators  | 
                                                  |_____________________|-| 
                                                  | execute()           | |-|
                                                  | extra()             | | |
                                                  |_____________________| | |
                                                    |_____________________| |
                                                      |_____________________|

 */

public class Notes {

}
