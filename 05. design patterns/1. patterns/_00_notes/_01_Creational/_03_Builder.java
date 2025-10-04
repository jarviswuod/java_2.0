package _01_Creational;

/*

    NOTES:
    - Builder pattern:
        - Is a creational Design pattern that separates the creation of a complex object from it's representation allowing the same construction process to create different representations
        - It provides a way to incrementally create objects, allowing you to create complex objects with different configurations while keeping the construction code separate from the final structure of the object
        - The pattern is most useful when creating objects with optional or variable components


    - 3 Main actors in Builder;
        a. Builders:
            - Is an interface that declare methods for building the various parts of a complex object

        b. Concrete Builder:
            - A subclass of builder that implements methods for building individual parts of a complex object

        c. Product:
            - It's a complex object being constructed typically composed of multiple parts


    - Advantages and Disadvantages
        - Advantages:
            - Common Approach: It promotes the separation of concerns effectively segregating the building process from the client code, this separation simplifies the management of complex creation and representation

            - Configurability: It enables the creation of objects with favors configurations while using the same building process

            - Improved Readability: It enhances code readability as primary code primarily concentrates on high level object construction rather than delving into detailed construction steps


        - Disadvantages:
            - Increased code Complexity: This complexity arises from the creation of multiple classes and interfaces which can make the overall code base more intricate. This can be problematic for smaller projects where the benefits of the pattern might not be fully realized
            - Potential for inconsistency: This arises because the pattern involves constructing an object step by step, if the builder is not used correctly there is a possibility of introducing inconsistencies. For instance forgetting to send the required property or setting property in the wrong order could result in an object that is invalid or unexpected state

 */

public class _03_Builder {

}
