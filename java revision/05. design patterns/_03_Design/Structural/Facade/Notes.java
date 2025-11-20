package _03_Design.Structural.Facade;

/*

    NOTES:
    - Facade design pattern:
        - Is a structural design pattern that simplifies the interaction to a complex system encapsulating complex subsystem

    - 3 key players:
        - Facade interface
        - Concrete Facade
        - SUbsystem


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

                        Payment payment = new Payment(orderRequest.getName(), orderRequest.getCardNumber(), orderRequest.getAmount());
                        payment.pay();

                        OrderFulfillment orderFulfillment = new OrderFulfillment(inventory);
                        orderFulfillment.fulfill(orderRequest.getName(), orderRequest.getAddress(), orderRequest.getItemIds());
                    }
                }

                class OrderRequest {

                    private String name = "Danny";
                    private String cardNumber = "1234";
                    private double amount = 20.99;
                    private String address = "123 Springfield Way, Texas";

                    // item ids user wants to order
                    private String[] itemIds = { "123", "456", "555", "989" };

                    public String getName() {
                        return name;
                    }

                    public String getCardNumber() {
                        return cardNumber;
                    }

                    public double getAmount() {
                        return amount;
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

                    public void reduceInventory(String itemId, int amount) {
                        System.out.println("Reducing inventory of " + itemId + " by " + amount);
                    }
                }

                class Payment {

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

    }
}