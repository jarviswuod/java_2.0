package _04_DesignPatterns.Structural.Facade;

/*

    NOTES:
    - The Facade Pattern:
        - Is a structural design pattern that provides a simplified interface to a complex system to help encapsulate it's complexities and improve the usability


    - CHALLENGE:
        - Say that we have an eCommerce application that allows users to submit orders

                                            ______________________
                           User submits     | Server             |
                             orders         |____________________|
                USER    ------------------->| Authenticate       |
                                            | Check Inventory    |
                  ^                         | Connect to payment |
                  |                         | Fulfill orders     |
                  |                         | Charge Users       |
                  |                         |____________________|
                  |          Response:                |
                  |     Success or failure            |
                  |___________________________________|



        - Each client that needs to make an order will be dependent on four classes;
                                         _________________
                                         |    Client     |
                                         |_______________|
                                                 |
                                                 |
                       __________________________|_____________________________
                       |                  |                |                  |
                       |                  |                |                  |
                       v                  v                v                  v
                ________________   _______________   ______________   ____________________
                | Authenticate |   | Inventory   |   | Payment    |   | OrderFulfillment |
                |______________|   |_____________|   |____________|   |__________________|



        - As you can see, every client that needs to make an order has to go through all the 5 main steps to make a single order. Every client becomes coupled to or dependent on four classes; Authenticate, Inventory, Payment, and OrderFulfillement

        - If we had ten classes that needed to make an order, then we'd have ten classes dependent on these four clases. That's a lot of coupling. If one of these four classes changes then ten classes that may need updating



    - FACADE PATTERN SOLUTION:
        - Clients making an order don't care or need to know about the steps involved in making an order. They just want to make an order
        - So, let's introduce OrderService class having only order() method that abstracts all the logic so all other classes that need to make order only have to depend on this one class

                                       _______________________
                                       |    OrderService     |
                                       |_____________________|
                                       | Order(orderRequest) |
                                       |_____________________|
                                                 |
                                                 |
                       __________________________|_____________________________
                       |                  |                |                  |
                       |                  |                |                  |
                       v                  v                v                  v
                ________________   _______________   ______________   ____________________
                | Authenticate |   | Inventory   |   | Payment    |   | OrderFulfillment |
                |______________|   |_____________|   |____________|   |__________________|




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
