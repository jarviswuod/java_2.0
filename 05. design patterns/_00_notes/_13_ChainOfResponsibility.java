/*

    NOTES:
    - Chain or repsonsibility pattern allows you to create a chain of objects where each object can either handle a request or pass it along to the next oject.
    - It decouples the sender of a request from it's receiver enabling multiple objects to handle the request without explictly specifying which object will process it

    - 2 Main actors in Chain;
        - Handler:
            - Is an interface that defines a common interface for handling requests, it contains a reference to the next handler in the chain

        - ConcreteHandler:
            - Is a subclass or handler that implements special request processing logic


    - Advantages and Disadvantages
        - Advantages:
            - Decoupling: It separates the sender and receiver. This separation allows for modification or the addition of handlers without any need to alter the client code
            - Flexilibity: It provides a dynamic and adaptable method for processing requests. Handlers can be effortlessly added, removed or rearranged facilitation easy modification to suit changing requirements
            - Single responsibility: Each handler in the chain of responsibility focuses on a specific task adhering to the single responsibility principle resulting in better organized and more maintainable code


        - Disadvantages:
            - Order Dependency: The sequence of handlers in the chain plays a crucial role and any misplacement might lead to bugs or unexpected outcomes
            - Unprocessed Request: The risk of requests going unprocessed, If a request traverses the entire chain without being addressed it remains pending which could pose problems depending of the applications context
            - Performance Overhead: SIngle all the request has to go through all the handers, it could introduce a performance overhead especially if the chain is lengthy

 */

public class _13_ChainOfResponsibility {

}
