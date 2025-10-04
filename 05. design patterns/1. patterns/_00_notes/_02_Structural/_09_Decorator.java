package _02_Structural;

/*

    NOTES:
    - Decorator Pattern:
        - Is a structural design pattern that allows you to dynamically add behaviors or responsibilities to objects without changing there code
        - It involves creating a set of decorators classes to wrap specific components, add new functionalities or runtime behaviors


    - 4 Main actors in Decorators;
        a. Component:
            - Defines a common interface for concrete components and decorators

        b. Concrete Component:
            - It implements the component interface and provides basic functionality that decorators can enhance

        c. Decorator:
            - Is an interface extending from the component, it maintains reference to the component instance

        d. Concrete decorators:
            - Are sub-classes of decorators that add specific behavior or responsibilities to a component


    - Advantages and Disadvantages
        - Advantages:
            - Open-closed Principle: It adheres to the open close principle as it allows for extending object functionalities without altering there existing code, this ensures the system is open for extension but closed for modification promoting a robust and flexible design
            - Flexibility: It allows for addition and combination of various decorators at runtime, this results in a dynamically changing system and flexible behavior extensions
            - Modularity: The pattern encourages a separation of responsibilities, this approach enhances the maintainability of the code making it easier to manage and update


        - Disadvantages:
            - Complexity: It introduces complexity resulting in an increased number of classes, this can make the code base more intricate and challenging to grasp especially for newcomers or those unfamiliar with the pattern
            - Order of Wrapping: The order in which decorators are applied is crucial as it can significantly impact the systems behavior. If not managed carefully this could lead to unexpected results potentially creating bugs or issues within the application

 */

public class _09_Decorator {

}
