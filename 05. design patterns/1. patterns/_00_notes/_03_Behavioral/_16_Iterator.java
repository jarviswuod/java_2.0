package _03_Behavioral;

/*

    NOTES:
    - Iterator Pattern:
        - Is a behavioral pattern that provides a way of iterating over an object without exposing the object's internal structure plus changing the object's internals should not affect it's consumers


    - 4 Main actors in Iterator;
        a. Iterator:
            - Is an interface that defines the methods for traversing a collections including operations like next() and hasNext()

        b. Concrete Iterator:
            - Is a class that implements the iterator interface and provides the actual traversal logic for a specific collection

        c. Collection:
            - An interface that defines methods for creating and iterating

        d. Concrete collection:
            - Is a class that implements the Collection interface providing the actual collection of elements and creating an appropriate iterator 


    - Advantages and Disadvantages
        - Advantages:
            - Decoupling: It introduces a notable level of decoupling effectively separating the traversal logic from the collection and ensuring a clean way of division of responsibilities. This separation enhances the maintainability and scalability of the code as changes in the traversal logic or the collection structure does not affect each other
            - Uniform interface: The iterator pattern provides a uniform interface ensuring a consistent and straightforward way to access elements across different collections. This uniformity significantly simplifies the client code, making it easier to manage and understand
            - Iterating complex structure: The pattern has the ability to handle iterating over complex data structures, this ensures the complexities involved do not burden the client allowing them to concentrate solely on there tasks
            - Multiple Iterators: The pattern supports the implementation of multiple iterators on the same collection, each providing a unique perspective of traversal. This feature is handy when different views or traversals of the data are required


        - Disadvantages:
            - Limited Functionality: The iterator provides just a basic set of traversal methods, this limitation is insufficient to cover all potentially use cases that may arise
            - Code overhead: The need to implement custom iterators and aggregators can lead to additional complexity in the code. This becomes especially visible in simple scenarios where such complexity may not be justified

 */

public class _16_Iterator {

}
