/*

    NOTES:
    - State is a behvioural design pattern that allows an object to alter its behavior when its internal state changes. 
    - It encpsulates different behaviours as separate state objects allowing the object to move between states while keeping it's interface consistent

    - 3  Main actors in State;
        - Context:
            - Is a class that maintains an internal state and contains a refence to the current state object. It delegates request to the current state
        - State:
            - Is an interface that defines the methods for handling requests
        - Concrete state:
            - Are classes that implememt the state interface and provide the behavior associalted with a specific state


    - Advantages and Disadvantages
        - Advantages:
            - Cleander code: This pattern allows you to put different behaviours in separate classes making the code more organized and easier to maintain
            - Flexibility: As context can switch between other states easily allowing dynamic behavior changes
            - OPen-closed principle: It adhears to the open closed principle as you can add new states or behaviors without changing existing code
            - Simplified context: The context code becomes more stragithforward and easier to understand as each state handles its behaviours


        - Disadvantages:
            - Complexity: It can add complexity especially when managing many states and transitions
            - Ordering and transitions: Managing the order of state transitons and ensuring correct behavior can be tricky leading to potential bugs

 */

public class _20_State {

}
