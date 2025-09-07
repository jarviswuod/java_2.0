package _03_Behavioural;
/*

    NOTES:
    - Mediator is a behavioural design pattern that facilitates communication between different objects withut them necesarily being aware of each other or being directly coupled, their interation is handles by a central point, the mediator

    - 4 Main actors in Mediator;
        - Mediator:
            - Is an interface that defines the commincation methods that concrete methods must implement.
            - It also maintains references to the specific objects
        - Concrete Mediator class:
            - It implements the mediator interface and manages the interactions and coordination between the participating objects
        - Component:
            - Is an interface that defines the commincation methods that concrete componenets must implement. It maintains a reference to the mediator
        - Concrete Components:
            - Are classes that implement the componenet interface and comminicate with the other componenets through the mediator


    - Advantages and Disadvantages
        - Advantages:
            - Decoupling and centralized control: It promoted loose coupling and easier maintainance by reducing direct dependies between components. This centralized control helps manage complex interactions and avoid tangles relationships among components.
            - Enhanced extensibility: Adding new components or chaning interactions patterns becomes easier with modifications being localized to the mediator enhancing extensibility


        - Disadvantages:
            - Complexity: Additonal complexity is realized particularly when dealing with many componenets and intricate interations
            - Single point of failure: It can become a single point of failure or a performance bottleneck if it become overly complex or tight coupled with the components
            - Limited components Independence: It limits the independence of the components since tehy need to communicate through the mediator which is only ideal on some scenarios
            - Performance overhead: Depending on how it;s implemented using mediator might introduce a slight performance overhead due to the additional layer of communication required

 */

public class _17_Mediator {

}
