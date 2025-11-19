package _02_Structural;

/*

    NOTES:
    - Flyweight Pattern:
        - Is a structural design pattern that aims to minimize memory usage by sharing common state betweeen multiple objects allowing efficient handling of large numbers of lightweight objects with shared characteristics


    - 3 Main actors in Flyweight;
        a. Flyweight Factory:
            -  This is a class that contains methods for getting all available flyweight classes

        b. Flyweight class:
            - It's responsible for managing and creating flyweight objects. It ensures that the shared states are reusable

        c. Objects:
            - Are the objects that flyweight class create containining repetitive information that we aim to optimize


    - Advantages and Disadvantages
        - Advantages:
            - Memory efficiency and performance: The pattern is highly beneficial for improving memory efficiency as it enables the sharing of repetitive states across multiple objects which is particularly useful when there are many instances of an object. This not only helps reduce memory consumption but also enhances the application's performance by minimizing the overhead associated with creating and destroying objects especially in resource intensive scenarios
            - Resource management: It aids in resource management by centralizing the control and management of the life cycle shared objects making it easier to handle them efficiently


        - Disadvantages:
            - Complexity: It can introduce a level of complexity especially when managing extrinsic states that cannot be shared and needs to be handled differently. This can make the implementation more challenging leading to errors if not managed correctly
            - Reduced flexibility: Because the pattern involves sharing intrinsic states among objects, it might limit the extent to which individual objects can be customized reducing flexibility in specific scenarios
            - Sharing vs. Duplication: There's a trade-off between sharing and duplication that needs to be carefully considered to ensure the correctness of the application. Deciding which states should be shared and which states should remain separate is critical to implementing the flyweight pattern. It requires evaluation to make the right choices for specific use case

 */

public class _11_Flyweight {

}
