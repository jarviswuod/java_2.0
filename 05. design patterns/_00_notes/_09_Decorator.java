/*

    NOTES:
    - Is a structural design pattern that allows you to dynamically add behaviors or responsilities to objects without changing there code.
    - It involves creating a set of decorators classes to wrap specific componenets, add new fucntionalities or runtime behaviours

    - 4 Main actors in Decorators;
        - Component:
            - Defines a common interface for concrete components and decorators
        - Concrete Component:
            - It implements the component interface and provides basic functionality that decorators can enhance
        - Decorator:
            - Is an interface extending from the  component, it maintand reference to the componenet instance
        - Concrete decorators:
            - Are subclasses of decorators that add specific behavour or responsilities to a component


    - Advantages and Disadvantages
        - Advantages:
            - Open-closed Principle: It adheres to the open close principle as it allows for extending object fucntionalities without altering there existing code, this ensures the sytem is open for extension but closed for modification promoting a robust and flexible design
            - Flexibility: It allows for addition and comination of various decorators at runtime, this results in a dynamically changing system and flexible behavior extensions
            - Modularity: The pattern encourages a separation of responsibilities, this approach enahnces the maintainablity of the code making it easier to manage and update


        - Disadvantages:
            - Complexity: It introduces complexity resulting in an increased number of classes, this can make the code base more intricate and challenging to grasp especially for newcomers or those unfamiliar with the pattern
            - Order of Wrapping: The order in which decorators are applied is crucial as it can significantly impact the systems behavoir. If not managed carefully this could lead to unexpected results potentially creating bugs or issues within the application

 */

public class _09_Decorator {

}
