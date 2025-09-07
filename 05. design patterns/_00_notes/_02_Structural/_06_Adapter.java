package _02_Structural;
/*

    NOTES:
    - The Adapter is a structural design pattern that allow objects with incompatible interfaces to work together by providing a bridge betweeen then.
    - It acts a translator allowing two classes with different interfaces to communicate and collaborate seamlessly

    - 3 Main actors in Adapter;
        - Target:
            - This is an interface that clients code expected to work with
        - Adaptee:
            - A class with an incompatible inteface that must be adapted to work with the client code
        - The Adapter:
            - This class implements the target interface and interacts internally with the adaptee translating calls and operations as needed


    - Advantages and Disadvantages
        - Advantages:
            - Interface Compatability: It enables classes with different interfaced to work together/unitedly significatly aiding in code reuse and seemless intergration. This patterns ensures that disperate systems communicate effectively enhancing the application overall architecture
            - Separation of conerns: It promotes a clear division between the client code and the complexities of external API. This separation fosters modularity making the system more managable and easier to navigate
            - Intergration with legacy code: It's invaluable when it comes to integrating pre-existing legacy code into new and involving systems. It ensures smooth transitions and enhanced compatibility


        - Disadvantages:
            - Complexity: It adds complexity to the code base. The added complexity can lead to challenges in understanging and maintaining the code particularly for those unfamiliar with the design pattern
            - Performance overhead: The pattern could slow down the system particularly when high efficiency and speed are crucial
            - Limited flexibility: It might require significant effort to implement when dealing with complex interfaces and API's. It may somethimes yield a clean and elegant solution potentially leading to imperfect results in terms code clarity and functionality

 */

public class _06_Adapter {

}
