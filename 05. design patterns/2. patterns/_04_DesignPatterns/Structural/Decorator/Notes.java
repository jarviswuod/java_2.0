package _04_DesignPatterns.Structural.Decorator;

/*

    NOTES:
    - Decorator pattern:
        - Is a structural design pattern that allows you to dynamically add behaviors or responsibilities to objects without changing their code
        - It involves creating a set of decorators classes to wrap specific components then add new functionalities or runtime behaviors


    - CHALLENGE:
        - Say that we have an application that allows users to store data in the cloud. The data can be sent to the cloud as it is without any processing and it can also be compressed and or encrypted before it's saved to the cloud

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
                        ______________________|_________________________
                        |                     |                        |
                        |                     |                        |
                  _______________      ________________      ___________________________
                  | Encryption  |      | Compression  |      | Encryption&Compression  |
                  |_____________|      |______________|      |_________________________|
                  | save(data)  |      | save(data)   |      | save(data)              |
                  |_____________|      |______________|      |_________________________|



        - So far, everything looks OK. But if we need to create a new Validation class to validate and clean the data before it is sent to the cloud. Our code starts to look bloated as we need to make lots of new classes just to add an extra feature

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
                        ___________________________________|____________________________________________
                        |           |         |            |                |                |         |
                        |           |         |            |                |                |         |
                  _______________   |   ________________   |   ___________________________   |    ______________
                  | Encryption  |   |   | Compression  |   |   | Encryption&Compression  |   |    | Validation |
                  |_____________|   |   |______________|   |   |_________________________|   |    |____________|
                  | save(data)  |   |   | save(data)   |   |   | save(data)              |   |    | save(data) |
                  |_____________|   |   |______________|   |   |_________________________|   |    |____________|
                                    |                      |                                 |
                                    |                      |                                 |
                  _________________________   __________________________   _____________________________________
                  | Encryption&Validation |   | Compression&Validation |   | Encryption&Compression&Validation |
                  |_______________________|   |________________________|   |___________________________________|
                  | save(data)            |   | save(data)             |   | save(data)                        |
                  |_______________________|   |________________________|   |___________________________________|


        - To add one more feature, we have to create four new classes. Our class library is growing exponentially



    - SOLUTION 2: DECORATOR CLASS:
        - You may have noticed by this point that a lof of design patterns are based on moving away from inheritance and towards composition. With composition, one object has reference to another object, and delegates it some work. This allows you to use polymorphism and switch between objects at runtime, making your code flexible. Whereas with inheritance, the object itself is able to do the work, inheriting the behaviour from it's superclass. With inheritance we have to create lots of new classes while with composition we can wrap or decorate existing objects to add new functionality

                                       ________________
                                       | Data         |<--------------------|
                                       |______________|                     |
                                       | save(data)   |                     |
                                       |______________|                     |
                                              ^                             |
                                              |                             |
                                ______________|_____________                |
                                |                          |                |
                                |                          |                |
                        __________________    __________________________    |
                        | CloudData      |    | DataDecorator          |    |
                        |________________|    |________________________|<>--|
                        | url            |    | wrappee: Data          |
                        |________________|    |________________________|
                        | cloudData(url) |    | dataDecorator(wrappee) |
                        | save(data)     |    | save(data)             |
                        |________________|    |________________________|
                                                          ^                   
                                                          |                   
                                           _______________|_________________  
                                           |                               |  
                                           |                               |  
                                  _______________________      ________________________ 
                                  | EncryptionDecorator |      | CompressionDecorator | 
                                  |_____________________|      |______________________| 
                                  | save(data)          |      | save(data)           | 
                                  |_____________________|      |______________________| 


            - Above, we make the encryption and compression objects decorators because they are decorating the CloudData object with some additional behaviour. Because decorator classes have some common logic e.g. referencing a CloudData object. We have created a DataDecorator class where this logic can be inherited to prevent code repetition

            - Our decorator classes are composed of or are decorating/wrapping a CloudData object or any object that implements the Data interface



    - DECORATOR PATTERN UML: From GoF book:

                                       ________________
                                       | Component    |<------------------------|
                                       |______________|                         |
                                       | execute()    |                         |
                                       |______________|                         |
                                              ^                                 |
                                              |                                 |
                                ______________|______________                   |
                                |                           |                   |
                                |                           |                   |
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
