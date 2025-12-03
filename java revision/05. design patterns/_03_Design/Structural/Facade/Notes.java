package _03_Design.Structural.Facade;

/*

    NOTES:
    - Facade design pattern:
        - Is a structural design pattern that simplifies the interaction to a complex system encapsulating complex subsystem

    - 3 key players:
        - Facade interface
        - Concrete Facade
        - Subsystem


                public class Notes {
                    public static void main(String[] args) {

                        OrderRequest orderRequest = new OrderRequest();
                        OrderService orderService = new OrderService();
                        orderService.order(orderRequest);
                    }
                }

                class OrderService {

                    public void order(OrderRequest orderRequest) {

                        Authenticate auth = new Authenticate();
                        auth.auth();

                        Inventory inventory = new Inventory();

                        for (String id : orderRequest.getItemIds()) {
                            inventory.checkInventory(id);
                        }

                        Payment payment = new Payment(orderRequest.getName(), orderRequest.getCardNumber(), orderRequest.getBalance());
                        payment.pay();

                        OrderFulfillment orderFulfillment = new OrderFulfillment(inventory);
                        orderFulfillment.fulfill(orderRequest.getName(), orderRequest.getAddress(), orderRequest.getItemIds());
                    }
                }

                class OrderRequest {

                    private String name = "Danny";
                    private String cardNumber = "1234";
                    private double balance = 20.99;
                    private String address = "123 Springfield Way, Texas";

                    // item ids user wants to order
                    private String[] itemIds = { "123", "456", "555", "989" };

                    public String getName() {
                        return name;
                    }

                    public String getCardNumber() {
                        return cardNumber;
                    }

                    public double getBalance() {
                        return balance;
                    }

                    public String getAddress() {
                        return address;
                    }

                    public String[] getItemIds() {
                        return itemIds;
                    }
                }

                class Authenticate {

                    public void auth() {
                        System.out.println("Auth done successful");
                    }
                }

                class Inventory {

                    public boolean checkInventory(String itemId) {
                        return true; // just return true to keep things simple
                    }

                    public void reduceInventory(String itemId, int quantity) {
                        System.out.println("Reducing inventory of " + itemId + " by " + quantity);
                    }
                }

                class Payment {

                    private String name;
                    private String cardNumber;
                    private double cost;

                    public Payment(String name, String cardNumber, double cost) {
                        this.name = name;
                        this.cardNumber = cardNumber;
                        this.cost = cost;
                    }

                    public void pay() {
                        System.out.println("Charging card with name " + name);
                    }
                }

                class OrderFulfillment {

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

 */

public class Notes {
    public static void main(String[] args) {

        OrderRequest orderRequest = new OrderRequest();
        OrderService orderService = new OrderService();
        orderService.order(orderRequest);
    }
}

class OrderService {

    public void order(OrderRequest order) {

        Authenticate auth = new Authenticate();
        auth.auth();

        Inventory_ inventory = new Inventory_();

        for (String id : order.getItemIds()) {
            inventory.checkInventory(id);
        }

        Payment payment = new Payment(order.getName(), order.getCardNumber(), order.getBalance());
        payment.pay();

        OrderFulfillment orderFulfillment = new OrderFulfillment(inventory);
        orderFulfillment.fulfill(order.getName(), order.getAddress(), order.getItemIds());
    }
}

class Authenticate {

    public void auth() {
        System.out.println("Auth done successful");
    }
}

class OrderRequest {

    private String name = "Danny";
    private String cardNumber = "1234";
    private double balance = 20.99;
    private String address = "123 Springfield Way, Texas";

    // item ids user wants to order
    private String[] itemIds = { "123", "456", "555", "989" };

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

    public String[] getItemIds() {
        return itemIds;
    }
}

class Inventory {

    public boolean checkInventory(String itemId) {
        return true; // just return true to keep things simple
    }

    public void reduceInventory(String itemId, int quantity) {
        System.out.println("Reducing inventory of " + itemId + " by " + quantity);
    }
}

class Payment {

    private String name;
    private String cardNumber;
    private double cost;

    public Payment(String name, String cardNumber, double cost) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cost = cost;
    }

    public void pay() {
        System.out.println("Charging card with name " + name);
    }
}

class OrderFulfillment {

    private Inventory_ inventory;

    public OrderFulfillment(Inventory_ inventory) {
        this.inventory = inventory;
    }

    public void fulfill(String name, String address, String[] items) {
        System.out.println("Inserting order into database");

        for (String item : items) {
            inventory.reduceInventory(item, 1);
        }
    }
}
