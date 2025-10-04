package _03_Behavioral;

/*

    NOTES:
    - Memento Pattern:
        - Is a behavioral design pattern that captures and externalizes the internal state of an object without breaking it's encapsulation
        - It allows you to save and restore state of an object providing the ability to undo or rollback changes, and also save history of the state


    - 3 Main actors in Memento;
        a. Originator:
            - Is a class whose state needs to be saved and restored. It creates memento objects to capture it's state and restore it's state from the memento

        b. Memento:
            - Is a class that stores the internal state of the originator

        c. Caretaker:
            - Is a class that stores and manages mementos, it stores and managed mementos. It requests mementos from the originator and can restore the originator state


    - Advantages and Disadvantages
        - Advantages:
            - State management: It enables preserving and restoring an object state thereby facilitating undo and history functions. This proves beneficial for objects requiring undo redo capabilities or a state of history record


        - Disadvantages:
            - Memory consumption: This is true for objects with intricate state structures as storing state history can be memory intensive, however there are memory optimization strategies that can help mitigate this issue
            - Performance overhead: The pattern can introduce performance overheads creating and managing mementos may lead to degradation in performance especially objects undergoing frequent state modifications
            - Limited Applicability: Applicability of the pattern is limited, while it offers significant value for objects that demand undo, redo functionalities or a history of state changes, implementing this pattern may be excessive for simpler patterns

 */

public class _18_Memento {

}
