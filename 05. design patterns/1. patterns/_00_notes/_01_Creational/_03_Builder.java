package _01_Creational;

/*

    NOTES:
    - Builder pattern:
        - Is a creational design pattern used to construct complex objects step by step, providing clarity and flexilibity in the creation process


    - 3 Main actors in Builder:
        a. Builder Interface:
            - Is an interface that declare methods for building the various parts of a complex object

        b. Concrete Builder:
            - A subclass of builder interface that implements methods for building individual parts of a complex object

        c. Product:
            - Is a complex object being constructed typically composed of multiple parts


    - Advantages and Disadvantages
        - Advantages:
            - Common Approach: It promotes the separation of concerns effectively segregating the building process from the client code. This separation simplifies the management of complex creation and representation

            - Configurability: It enables the creation of objects with favors configurations while using the same building process

            - Improved Readability: It enhances code readability as primary code primarily concentrates on high level object construction rather than delving into detailed construction steps


        - Disadvantages:
            - Increased code Complexity: This complexity arises from the creation of multiple classes and interfaces which can make the overall code base more intricate. This can be problematic for smaller projects where the benefits of the pattern might not be fully realized
            - Potential for inconsistency: This arises because the pattern involves constructing an object step by step. If the builder is not used correctly there is a possibility of introducing inconsistencies

 */

public class _03_Builder {

}
