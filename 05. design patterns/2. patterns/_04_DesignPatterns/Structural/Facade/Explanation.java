package _04_DesignPatterns.Structural.Facade;

/*

    CODE EXPLANATION:

    - CHALLENGE:
        - Say that we have an eCommerce application that allows users to submit orders
        - Every client that needs to make an order has to go through all the 5 main steps to make a single order. Every client becomes coupled to, or dependent on, four classes; Authenticate, Inventory, Payment, and OrderFulfillment

    - SOLUTION 1:
        - We have some random code to simulate steps involved in processing an order

        - OrderRequest class:
            - This is the request object containing the user-submitted data in a form they filled
            - The user has a name, cardNumber they entered, amount for the order, address of the user and the itemId's that the user wants to order

                public class OrderRequest {

                    public String name = "Danny";
                    public String cardNumber = "1234";
                    public double amount = 20.99;
                    public String address = "123 Springfield Way, Texas";

                    // item ids user wants to order
                    public String[] itemIds = { "123", "456", "555", "989" };
                }


        - Authenticate class;
            - We go through some authenication steps, the class is empty to make things simple but this might check the user's session, checks whether the session is valid and that the username etc

                public class Authenticate {

                }


        - Inventory class:
            - We have a couple of methods checkInventory() receives itemIds to check the items availablility
            - reduceInventory() it reduces the inventory of an itemId passed by a certain amount

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
            - Here we can set the name, cardNumber and amount that the user owes for the order
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
            -  Which checks the inventory object if we have sufficient inventory
            - We have a fulfill() method which is going to loop through the items  in the items list i.e items that the user is going to user wants to use and it's going to reduce the inventory of those items in the loop
            - We also have a log to console "inserting the orde into the db"

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
            - NOTE: - All these are classes that simulate the process involved in the order process
            - IMPORTANT BIT: how the client interacts with the solution;

            - We create a new orderRequest object
            - We then create our authenication object
            - Then we create our Inventory object and over here we will loop through our orderRequest itemIds and then we can check the inventory for each id
            - Then we create our payment ovject passing information from the OrderRequest object and then we call payments.pay() method
            - Finally we create our orderFulfillment object where we pass our inventroy object and then we call our fulfill() method passing infor from orderRewuest object
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
        - We maintain every single class we had from Authenticate, Inventory, Payment, and OrderFulfillment. We only introduce an OrderSerice class to act as an abstraction

        - OrderService class
            - This class acta as Facade that encapulates all the complexities and steps involved in making an order so clients can then make orders without having to know all the details or steps involved in the order process

            - We have a single method called order() it takes in OrderRequest and then over here we'll have all the steps involved in maknig an order - this will be excactly the same as what we have under our Main class currently

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
            - All we need here is the orderRequest object
            - We then create an orderService object and then call the order() method passing in the orderRequest object we just created above

                public class Main {
                    public static void main(String[] args) {

                        OrderRequest orderRequest = new OrderRequest();
                        OrderService orderService = new OrderService();
                        orderService.order(orderRequest);
                    }
                }


        - OBSERVATION:
            - Code works excactly the same as before. Now clients can make order without having to depend on many classes and without having to know about all the complexities involved in making an order, all the complexities are abstracted away and encapulated within the orderService class

 */

public class Explanation {

}