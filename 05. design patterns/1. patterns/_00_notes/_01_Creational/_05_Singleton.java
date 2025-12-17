package _01_Creational;

/*

    NOTES:
    - Singleton Pattern:
        - Is a creational design pattern that ensures that a class only has one instance and provides a global access point to that instance
        - The single instance is commonly used for managing shared resources, configuration settings, or logging functionality within an application


    - 1 Main actor in Singleton:
        a. Singleton:
            - Is a class that implements the singleton pattern ensuring only one instance of it can exist


    - Advantages and Disadvantages
        - Advantages:
            - Global Access: It provides a single well defined access point to an instance ensuring global access and making it easy to manage and use throughout the application
            - Resource Management: It controls the allocation and release of resources guaranteeing their efficient use
            - State Management: It's capable of maintaining a unique state within an application which is particularly useful for storing configurations setting or shared data that needs to be accessed by various components
            - Lazy Initialization: It supports resource loading on demand. This improves performance by deferring the load of the resources until it's needed


        - Disadvantages:
            - Testing: The pattern can be a challenging task due to tight coupling and global nature of a singleton, making the code-base difficult to test
            - Race conditions: In multi-threaded environment there's an added complexity as creation of a singleton must be thread safe to prevent race conditions ensuring the instance is created only once even when multiple threads attempt to create it simultaneously
            - Anti-pattern: It's seen as an anti-pattern because it adds complexity to the code and is very difficult to reuse or test

 */

public class _05_Singleton {

}
