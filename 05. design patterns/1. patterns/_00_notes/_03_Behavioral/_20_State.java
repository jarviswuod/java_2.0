package _03_Behavioral;

/*

    NOTES:
    - State Pattern:
        - Is a behavioral design pattern that allows an object to alter it's behavior when it's internal state changes 
        - It encapsulates different behaviors as separate state objects allowing the object to move between states while keeping it's interface consistent


    - 3  Main actors in State;
        a. Context:
            - Is a class that maintains an internal state and contains a reference to the current state object. It delegates request to the current state

        b. State:
            - Is an interface that defines the methods for handling requests

        c. Concrete state:
            - Are classes that implement the state interface and provide the behavior associated with a specific state


    - Advantages and Disadvantages
        - Advantages:
            - Cleaner code: This pattern allows you to put different behaviors in separate classes making the code more organized and easier to maintain
            - Flexibility: As context can switch between other states easily allowing dynamic behavior changes
            - Open-closed principle: It adhere to the open closed principle as you can add new states or behaviors without changing existing code
            - Simplified context: The context code becomes more straightforward and easier to understand as each state handles it's behaviors


        - Disadvantages:
            - Complexity: It can add complexity especially when managing many states and transitions
            - Ordering and transitions: Managing the order of state transitions and ensuring correct behavior can be tricky leading to potential bugs

 */

public class _20_State {

}
