package _02_Structural;

/*

    NOTES:
    - Adapter Pattern:
        - Is a structural design pattern that allow objects with incompatible interfaces to work together by providing a bridge between them
        - It acts as a translator allowing two classes with different interfaces to communicate and collaborate seamlessly


    - 3 Main actors in Adapter:
        a. Target:
            - This is an interface that clients code expected to work with

        b. Adaptee:
            - A class with an incompatible interface that must be adapted to work with the client code

        c. Adapter:
            - This class implements the target interface and interacts internally with the adaptee translating calls and operations as needed


    - Advantages and Disadvantages
        - Advantages:
            - Interface Compatibility: It enables classes with different interfaces to work unitedly significantly aiding in code reuse and seamless integration. This patterns ensures that desperate systems communicate effectively enhancing the application overall architecture
            - Separation of concerns: It promotes a clear division between the client code and the complexities of external API. This separation fosters modularity making the system more manageable and easier to navigate
            - Integration with legacy code: It's invaluable when it comes to integrating pre-existing legacy code into new and involving systems. It ensures smooth transitions and enhanced compatibility


        - Disadvantages:
            - Complexity: It adds complexity to the codebase. The added complexity can lead to challenges in understanding and maintaining the code particularly for those unfamiliar with the design pattern
            - Performance overhead: The pattern could slow down the system particularly when high efficiency and speed are crucial
            - Limited flexibility: It might require significant effort to implement when dealing with complex interfaces and API's

 */

public class _06_Adapter {

}
