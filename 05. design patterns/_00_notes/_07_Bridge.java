/*

    NOTES:
    - Bridge is a design pattern that separates obstruction from implementation allowing them to evolve independently.
    - It decouples an obstructions iterface from its implementation allowing changes in one without affecting the other
    - This pattern comes in handly when dealing with comples class hierarchies and when both changes in both teh obstruction and implementation are expected

    - 3 Main actors in Bridge Design Pattern;
        - Abstraction:
            - Is a high level interface that defines methods and properties for implementation and keeps a refence to the latter.
        - Implementation:
            -  Is a low level interface that defines the method and properties to be implemented by concrete classes
        - Concrete Implementations:
            - Are subclasses to the implementation that provide the actual implementations



    - Advantages and Disadvantages
        - Advantages:
            - Decoupling: Offers a significant level of decoupling between obstruction and implementation meaning changes can be made on either sides without impacting the other making system maintance easier
            - Extension: The pattern facilitates extensions allowing new obstructions and implementations to be added indepently without much FAS


        - Disadvantages:
            - Complexity: It can introduce additional complexity to the system particularly when there are multiple levels of obstruction and implementation. In scenarios where the system is quite simple employing the bridge pattern might lead to unnecessary overhead, uncecessarily complicating both the code and the overall design 

 */

public class _07_Bridge {

}
