package _03_Behavioral;

/*

    NOTES:
    - Visitor Pattern:
        - Is a behavioral pattern that separates algorithms from an object structure on which it operates on


    - 4 Main actors in Visitor;
        a. Visitor Interface:
            - It declares the methods for each element type in the hierarchy

        b. Concrete visitors:
            - Are classes that implement the visitor and provide the implementations for it's methods

        c. Element interface:
            - It declares the accept method which accepts the visitor

        d. Concrete Element:
            - Are concrete classes that implements the element interface and it's methods. They receive the visitor and delegate the visit to the appropriate method


    - Advantages and Disadvantages
        - Advantages:
            - Separation of concerns: It separates operations from element classes enhancing clarity and maintainability
            - Open-closed principle: It's highly extensible allowing new operations to be added without changing existing element classes, this aligns with the open closed principle as adding new visitors and operations does not require modifying existing code
            - Double dispatch: Visitor facilitates double dispatch enabling the right method to be called based on both the element and the visitor


        - Disadvantages:
            - Complexity: It can add complexity especially when there are many elements and visitors to manage
            - Code duplication: Similar operations on different element types might result in repeated code when multiple visitors are implemented
            - Limited applicability: When it's highly valuable for complex structures and numerous operations, it may be excessive for more straightforward situations

 */

public class _23_Visitor {

}
