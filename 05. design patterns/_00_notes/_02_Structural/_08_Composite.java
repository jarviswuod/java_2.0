package _02_Structural;
/*

    NOTES:
    - Composite is a structural design pattern that combines objects into tree like structures to represent part-whole hierarchies.
    - It handles individual objects and objeect compositions uniformly allowing clients to work with complex structures and particular object using a single interface

    - 3 Main actors in Composite;
        - Component:
            - This defines the common interface for leaf and compside knots
        - Leaf And Composite:
            - Are classes that both implement the component interface but 'leaf' represents the indivual object in the composition while 'composite' respresents the composition itself and contains set of child components


    - Advantages and Disadvantages
        - Advantages:
            - Unified Interface: It provides a consistent way to work with individual objects and complex compositions. This consistency simplifies client code and enhances ease of use
            - Recursive structure: It's recursive structure is beneficial for respresenting complex hierachical structures in a clean and organised manner
            - Flexibility: The pattern is higly flexible allowing the incorporation of new components, be they leaf or composite without any destructive effects on the existing structure or client code


        - Disadvantages:
            - Complexity: The introduction of the composite pattern can lead to increased complexity particularly in the situation involving deeply nested hierarchies
            - Overhead: Operations performed on composite objects may require traversl through the entire hierarchy poterntially leading to performance issues. In simple scenarios applying composite pattern may result in uncessary overhead complicating the code and overall design

 */

public class _08_Composite {

}
