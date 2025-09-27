package _01_Creational;
/*

    NOTES:
    - The builder is a creational Design pattern that separated the creation of a complex object from it's representation allowing the same construction process to create differenct representations
    - It provides a way to incrementally create objects, allowing you to create complex objects with different configurations while keeping the construction code separate from the final strcuture of the object
    - The pattern is most useful when creating objects with optional or variable components


    - 3 Main actors in Builder;
        - Builders:
            - Is an interface that decleares methods for building the various parts of a complex object

        - Concrete Builder:
            - A subclass of builder that implements methods for building individual parts of a complex object

        - Product:
            - It's a complex object being constructed typically composed of multiple parts


    - Advantages and Disadvantages
        - Advantages:
            - Common Approach: It promotes the separation of concerns efectively segregating the building process from the client code, this separation simplfies teh management of complex creation and respresentation

            - Configurability: It enables the creation of objects with favious configurations while using the same building process

            - Improved Readability: It enhances code readability as primary code primarily concentrates on high level object construction rather than delving into detailed construction steps


        - Disadvantages:
            - Increased code Complexity: This complexity arises from the creation of multiple classes and interfaces which can make the overall code base more intricate. This can be probematic for smaller projects where the benefits of the pattern might not be fully realised
            - Potential for inconsistency: This arises because the pattern involves constructing an object step by step, if the builder is not used correctly there is a possibility of introducing inconsistencies. For instance forgetting to send the required property or setting property in the wrong order could result in an object that is invalid or unexpected state

 */

public class _03_Builder {

}
