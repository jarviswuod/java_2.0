/*

    NOTES:
    - Memento is a behavioural design pattern that captures and externalizes the internal state of an object without breaking it's encapsulation.
    - It allows you to save and restore state of an object providing the ability to undo or rollback changes, and also save a history of the state

    - 3 Main actors in Memento;
        - Originator:
            - Is a class whose state needs to be saved and restored. It creates memento objects to capture it's state and restore it's state from the memento
        - Memento:
            - Is a class that stores the internal state of the originator
        - Caretaker:
            - Is a class that stores and manages mementos, it stores and managed mementos. It requests mementos from the originator and can restore the originator state


    - Advantages and Disadvantages
        - Advantages:
            - State management: It enables preserving and restoring an object state thereby facilitating undo and history functions. This proves benefiticial for objects requiring undo redo capabilities or a state of history record


        - Disadvantages:
            - Memory consumption: This is true for objects with intricate state structures as storing state history can be memory intensive, however there are memory optimization strategies that can help mitigate this issue
            - Performance overhead: The pattern can introduce perfomance overheads creating and manageing mementos may lead to degradation in performance especially objects undergoing frequent state modifications
            - Limited Applicability: Applicability of the pattern is limited, while it offeres significant value for objects that demand undo, redo functionalities or a history of state changes, implementing this pattern may be execessive for simpler pattens

 */

public class _18_Memento {

}
