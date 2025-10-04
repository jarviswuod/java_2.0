package _02_Structural;

/*

    NOTES:
    - Proxy Pattern:
        - Is a structural design pattern that provides a placeholder for another object to control it's access
        - It acts as an intermediary allowing you to add additional behavior or control to the original object without modifying it's code
        - They are commonly used for various aspects including controlling access, managing resources and delaying object creation


    - 3 Main actors in Proxy;
        a. Subject:
            - Is a generic interface that defines both methods, the real subject and the proxy implement this allows you to use a proxy instead of a real object

        b. Real subject:
            - Is a class that represents the real object or service that the proxy controls access to

        c. Proxy:
            - A class that implements the same interface as the subject it contains a real subject and controls access to it adding any necessary functionality


    - Advantages and Disadvantages
        - Advantages:
            - Access control: It enhances access control by enabling you to manage the permissions and access to the real subject, adding an extra layer of security or authorization, this can be particularly crucial in scenarios where sensitive information or operations are involved
            - Resource management: It aids in efficient resource management as proxies have the ability to handle resource related to the real subject. This contains lazy initialization, caching and releasing resources when they are no longer necessary contributing to a more optimized use of system resources
            - Performance optimization: It optimizes the performance of the system for example it can postpone the creation or execution of  resource heavy objects or tasks or reuse just calculated results
            - Simplified client code: The client code just becomes simpler and more straightforward when using the proxy pattern. The complexity of functionalities or interactions is encapsulated within the proxy making it easier for the client code to interact with the real subject


        - Disadvantages:
            - Complexity: Introduction of proxy can lead to increased complexity in the system. This is particularly evident  when managing various types of proxies, and understanding their interaction which can become a challenging task
            - Overhead: As proxies add an extra layer of indirection there is a slight performance overhead though this is typically outweigh by the performance benefit in most scenarios

 */

public class _12_Proxy {

}
