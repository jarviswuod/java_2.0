package _04_DesignPatterns.Structural.Facade;

/*

    NOTES:
    - The Facade Pattern:
        - Is a structural design pattern that provides a simplified interface to a complex system, encapsulating the complexities of multiple subsystems into a single unified interface for clients

    - CHALLENGE:
        - Say that we have an eCommerce application that allows users to submit orders

                                        ______________________
                       User submits     | Server             |
                         orders         |____________________|
            USER    ------------------->| Authenticate       |
                                        | check Inventory    |
                                        | Connect to payment |
                                        | fulfill orders     |
                                        | charge Users       |
                ^                       |____________________|
                |        Response:               |
                |     Success or failure         |
                |________________________________|


        - As you can see, every client that needs to make an order has to go through all the 5 main steps to make a single order. Every client becomes coupled to, or dependent on, four classes; Authenticate, Inventory, Payment, and OrderFulfillement

        - If we had ten classes that needed to make an order, then we'd have ten classes dependent on these four clases - that's a lot of coupling. If one of these four classes changes, that's ten classes that may need updating. Not good

        - Each client that needs to make an order will be dependent on four classes;

                                        _________________
                                        |  Client       |
                                        |_______________|
                                                |
                                                |
                    ____________________________|__________________________________
                    |                     |                   |                   |
                    |                     |                   |                   |
                    v                     v                   v                   v
                _________________  __________________   ______________   ____________________
                | Authenticate  |  | Inventory      |   | Payment    |   | OrderFulfillment |
                |_______________|  |________________|   |____________|   |__________________|




    - FACADE PATTERN SOLUTION:
        - Clients making an order don't care and don't need to know about the steps involved in making an order; they just want to make an order
        - So, let's introduce a new class, OrderService, with a single method, order(), that abstracts all the logic, so all other classes that need to make order only have to depend on this one class

                                        _______________________
                                        | OrderService        |
                                        |_____________________|
                                        | Order(orderRequest) |
                                        |_____________________|
                                                |
                                                |
                    ____________________________|__________________________________
                    |                     |                   |                   |
                    |                     |                   |                   |
                    v                     v                   v                   v
                _________________  __________________   ______________   ____________________
                | Authenticate  |  | Inventory      |   | Payment    |   | OrderFulfillment |
                |_______________|  |________________|   |____________|   |__________________|


        - Now, all classes that need to be able to make an order only need to depend on the one OrderService class:
                    ____________         ___________         _____________
                    |          |         | Main    |         |           |
                    |__________|         |_________|         |___________|
                    |          |         |         |         |           |
                    |__________|         |_________|         |___________|
                        |                     |                     |
                        |_____________________|_____________________|
                                              |
                                              |
                                              v
                                      __________________
                                      | OrderService   |
                                      |________________|
                                      |                |
                                      |________________|

 */

public class Notes {

}
