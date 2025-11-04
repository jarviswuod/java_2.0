package _03_Behavioral;

/*

    NOTES:
    - Subscriber Pattern:
        - Is a behavior pattern that defines a one to many relationship between objects where changes in one object are automatically communicated to and reflected in other objects
        - It enables loosely coupled and efficient communication mechanism between components


    - 3 Main actors in Subscriber:
        a. Publisher:
            - Is a class that contains a list of independent observers and notifies them of any state changes. It provides methods to attach, detect and notify observers

        b. Subscriber:
            - Is an interface that defines the update method to be called when the publisher's state changes

        c. Concrete Subscribers:
            - Are classes that implement the subscriber interface and receive updates from the publisher when it's state changes


    - Advantages and Disadvantages
        - Advantages:
            - Dynamic updates: The pattern supports for dynamic updates at runtime. Objects can be dynamically added or removed from the list of subscribers providing great flexibility in managing dependencies between objects
            - Efficient Communication: The pattern ensures efficient communication between objects. Subscribers are only notified when relevant changes in the publisher state occurs preventing unnecessary updates and helping keep the system efficient
            - Consistency: The pattern aids in maintaining consistency within the system. It guarantees that all subscribers are kept in sync with the publisher's state ensuring that each dependent object is updated appropriately to reflect the current state


        - Disadvantages:
            - Complexity: The pattern can introduce additional complexity to a system particularly when there are many subscribers to manage and their specific interaction become intricate. This complexity can make the system harder to understand and maintain
            - Unexpected updates. If used excessively, the publisher's state changes frequently which can lead to unexpected updates cascading through out the system. This can make the behavior of the system unpredictable and challenging to debug
            - Ordering dependency: The order in which subscribers are notified can be an essential factor in some systems and the subscriber pattern does not inherently provide a way to manage this. This can lead to design challenges and result in code that is hard maintain

 */

public class _19_Observer {

}
