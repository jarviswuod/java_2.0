package _03_Behavioral;

/*

    NOTES:
    - Template Method Pattern:
        - Is a behavioral pattern that allows you to define a template method or skeleton for an algorithm with specific steps implemented in subclasses


    - 2 Main actors in Template Method;
        a. Abstract class:
            - Is the base class that defines the template method and outlines the algorithm structure. It may also provide default implementations for some steps

        b. Concrete class:
            - Is a subclass of an abstract class that provides concrete implementations for the steps defined in the template method


    - Advantages and Disadvantages
        - Advantages:
            - Code reuse: It promotes efficiency by enabling various sub-classes to share a common structure
            - Flexibility: It offers flexibility by enabling sub-classes to override specific steps or providing different ways of implementing certain behaviors
            - Separation of concern: It has the ability to separate the high level algorithm from the specific implementation details ensuring a clear organization of concerns


        - Disadvantages:
            - Maintenance challenges: This is because changes in the main class impacts all sub-classes so managing and updating the code without affecting the application areas can be tricky

 */

public class _22_TemplateMethod {

}
