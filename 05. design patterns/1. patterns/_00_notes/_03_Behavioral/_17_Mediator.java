package _03_Behavioral;

/*

    NOTES:
    - Mediator is a behavioral design pattern that facilitates communication between different objects without them necessarily being aware of each other or being directly coupled, their interaction is handles by a central point, the mediator

    - 4 Main actors in Mediator;
        - Mediator:
            - Is an interface that defines the communication methods that concrete methods must implement.
            - It also maintains references to the specific objects
        - Concrete Mediator class:
            - It implements the mediator interface and manages the interactions and coordination between the participating objects
        - Component:
            - Is an interface that defines the communication methods that concrete components must implement. It maintains a reference to the mediator
        - Concrete Components:
            - Are classes that implement the component interface and communicate with the other components through the mediator


    - Advantages and Disadvantages
        - Advantages:
            - Decoupling and centralized control: It promoted loose coupling and easier maintenance by reducing direct dependencies between components. This centralized control helps manage complex interactions and avoid tangles relationships among components.
            - Enhanced extensibility: Adding new components or chaining interactions patterns becomes easier with modifications being localized to the mediator enhancing extensibility


        - Disadvantages:
            - Complexity: Additional complexity is realized particularly when dealing with many components and intricate interaction
            - Single point of failure: It can become a single point of failure or a performance bottleneck if it become overly complex or tight coupled with the components
            - Limited components Independence: It limits the independence of the components since they need to communicate through the mediator which is only ideal on some scenarios
            - Performance overhead: Depending on how it;s implemented using mediator might introduce a slight performance overhead due to the additional layer of communication required

 */

public class _17_Mediator {

}
