package _03_Behavioural;
/*

    NOTES:
    - The Visitor design pattern is a behavioural pattern that allows you to add new operation to the existing classes without modifying there structure.
    - It separates the operations from the classes they operate on by encapsulating them in visitor object
    - This pattern is handy when dealing with a structured hierachy of classes and multiple operations that need to be performed on those classes 

    - 4 Main actors in Visitor;
        - Visitor Interface:
            - It declears the methods for each element type in the hierarchy
        - Concrete visitors:
            - Are classes that implement the visitor and provide the implementations for its methods
        - Element interface:
            - It declears the accept method which accepts the visitor
        - Concrete Element:
            - Are concrete classes that implements the element interface and it's methods. They receive the visitor and delegate the visit to the appropriate method


    - Advantages and Disadvantages
        - Advantages:
            - Separation of concerns: It separates operations from element classes enhancing clarity and maintainability
            - Open-closed principle: It's highly extensible allowing new operations to be added without changeing existing element classes, this aligns with the open closed priciple as adding new visitors and operations doesn't require modifying existing code
            - Double dispatch: Visitor facilitates double dispatch enabling the right method to be called based on both the element and the visitor


        - Disadvantages:
            - Complexity: It can add complexity especially when there are many elements and visitors to manage
            - Code duplication: Similar operations on different element types might result in repeated code when multiple visitors are implemented
            - Limited applicability: When it's highly valuable for complex structures and numerous operations, it may be excessive for more straightfoward situations

 */

public class _23_Visitor {

}
