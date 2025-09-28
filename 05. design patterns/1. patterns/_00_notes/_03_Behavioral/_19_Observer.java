package _03_Behavioral;

/*

    NOTES:
    - The observer is a behavior pattern that defines a one to many relationship between objects, where changes in one object are automatically communicated to and reflected in other objects. It enables loosely coupled and efficient communication mechanism between components

    - 3 Main actors in Observer;
        - Subject/ Publisher:
            - Is a class that contains a list of independent observers and notifies them of any state changes. It provided methods to attach/detect and notify observers
        - Observer/ Subscriber:
            - Is an interface that defines the update method to be called when the subject's state changes
        - Concrete Observers:
            - Are classes that implement the observer interface and receive updates from the subject when it's state changes


    - Advantages and Disadvantages
        - Advantages:
            - Dynamic updates: The pattern supports for dynamic updates at runtime objects can be dynamically added or removed from the list of observers providing great flexibility in managing dependencies between objects
            - Efficient Communication: The pattern ensures efficient communication between objects. Observers are only notified when relevant changes in the subject state occurrence preventing unnecessary updates and helping keep the system efficient
            - Consistency: The pattern aids in maintaining consistency within the system. it guaranteeing that all observers are kept in sync with the subject's state ensuring that each dependent object is updated appropriately to reflect the current state


        - Disadvantages:
            - Complexity: The pattern can introduce additional complexity to a system particularly when there are many observers to manage and their specific interaction become intricate. This complexity can make the system harder to understand and maintain
            - Unexpected updates. If used excessively, the subject's state changes frequently, it can lead to unexpected updates and cascading through out the system. This can make the behavior of the system unpredictable and challenging to debug
            - Ordering dependency: The order in which observers are notified can be essential factor in some systems and the observer pattern does not inherently provide a way to manage this. This can lead to design challenges and result in code that is hard maintain

 */

public class _19_Observer {

}
