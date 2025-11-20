package _04_DesignPatterns.Structural.Facade;

/*

    CODE EXPLANATION:

    - CHALLENGE:
        - Say that we have an eCommerce application that allows users to submit orders. Every client that needs to make an order has to go through all the 5 main steps to make a single order. Every client becomes coupled to or dependent on four classes; Authenticate, Inventory, Payment, and OrderFulfillement. That's a lot of coupling


    - SOLUTION 1:
        - We have some random code to simulate steps involved in processing an order

        - OrderRequest class:
            - This is the request object containing the user-submitted data from a filled form
            - It contains a name, user's cardNumber, amount for the order, user's address and user's oredered item Id's

                    public class OrderRequest {

                        private String name = "Danny";
                        private String cardNumber = "1234";
                        private double amount = 20.99;
                        private String address = "123 Springfield Way, Texas";

                        // item ids user wants to order
                        private String[] itemIds = { "123", "456", "555", "989" };
                    }


        - Authenticate class:
            - We go through some authentication steps
            - The class is empty to make things simple but this might check the user's session checking if the session is valid

                    public class Authenticate {

                    }


        - Inventory class:
            - checkInventory() method receives itemIds and checks for items availablility
            - reduceInventory() reduces the inventory of an itemId passed by a certain amount

                    public class Inventory {

                        public boolean checkInventory(String itemId) {
                            return true; // just return true to keep things simple
                        }

                        public void reduceInventory(String itemId, int amount) {
                            System.out.println("Reducing inventory of " + itemId + " by " + amount);
                        }
                    }


        - Payment class:
            - This class handles payment step within the order process
            - Here we set the name, cardNumber and amount that the user owes for the order
            - We have a method called pay() which simulates connection to some payment service and charging the user's card

                    public class Payment {

                        private String name;
                        private String cardNumber;
                        private double amount;

                        public Payment(String name, String cardNumber, double amount) {
                            this.name = name;
                            this.cardNumber = cardNumber;
                            this.amount = amount;
                        }

                        public void pay() {
                            System.out.println("Charging card with name " + name);
                        }
                    }


        - OrderFulfillment class:
            -  Checks inventory object to verify we have sufficient inventory
            - fulfill() method loops through items in items list i.e items the user is buying and it's reduces the inventory of those items in the loop
            - We also log to console "inserting order into database"

                    public class OrderFulfillment {

                        private Inventory inventory;

                        public OrderFulfillment(Inventory inventory) {
                            this.inventory = inventory;
                        }

                        public void fulfill(String name, String address, String[] items) {
                            System.out.println("Inserting order into database");

                            for (String item : items) {
                                inventory.reduceInventory(item, 1);
                            }
                        }
                    }



        - Main class: Client Class
            - We create a new OrderRequest object
            - We then create a new Authentication object
            - Then create Inventory object and over here we will loop through our orderRequest itemIds and then we can check the inventory for each id
            - Then we create Payment object passing information from the OrderRequest object calling payments.pay() method
            - Finally, create OrderFulfillment object where we pass our inventroy object calling fulfill() method passing infor from orderRequest object
            - It's all working and running smooth

                    public class Main {
                        public static void main(String[] args) {

                            OrderRequest orderRequest = new OrderRequest();
                            Authenticate auth = new Authenticate();

                            System.out.println(auth);

                            Inventory inventory = new Inventory();
                            for (String id : orderRequest.itemIds) {
                                inventory.checkInventory(id);
                            }

                            Payment payment = new Payment(orderRequest.name, orderRequest.cardNumber, orderRequest.amount);
                            payment.pay();

                            OrderFulfillment orderFulfillment = new OrderFulfillment(inventory);
                            orderFulfillment.fulfill(orderRequest.name, orderRequest.address, orderRequest.itemIds);
                        }
                    }



    - SOLUTION 2: FACADE PATTERN;
        - We maintain every single class we had from Authenticate, Inventory, Payment to OrderFulfillment. We only introduce an OrderService class to act as an abstraction

        - OrderService class
            - This class acts as a Facade that encapsulates all complexities and steps involved in making an order so clients can then make orders without having to know all the details or steps involved in the order process

            - We have order() method which takes in OrderRequest and then over here we'll have all the steps involved in making an order. This will be exactly the same as what we have under our Main class currently

                    public class OrderService {

                        public void order(OrderRequest orderReq) {

                            OrderRequest orderRequest = new OrderRequest();
                            Authenticate auth = new Authenticate();

                            System.out.println(auth);

                            Inventory inventory = new Inventory();
                            for (String id : orderRequest.itemIds) {
                                inventory.checkInventory(id);
                            }

                            Payment payment = new Payment(orderRequest.name, orderRequest.cardNumber, orderRequest.amount);
                            payment.pay();

                            OrderFulfillment orderFulfillment = new OrderFulfillment(inventory);
                            orderFulfillment.fulfill(orderRequest.name, orderRequest.address, orderRequest.itemIds);
                        }
                    }



        - Main class: Client class;
            - All we need here is the OrderRequest object
            - We then create an OrderService object and then call the order() method passing in the orderRequest object we just created above

                    public class Main {
                        public static void main(String[] args) {

                            OrderRequest orderRequest = new OrderRequest();
                            OrderService orderService = new OrderService();
                            orderService.order(orderRequest);
                        }
                    }


        - OBSERVATION:
            - Code works excactly the same as before. Now clients can make order without having to depend on many classes and without having to know about all the complexities involved in making an order, all the complexities are abstracted away and encapulated within the OrderService class

 */

public class Explanation {

}