package _03_Design.Structural.Facade;

/*

    NOTES:
    - Is a structural design pattern that simplifies the complexity of an object interface encapsulating both complex and uncessesary implementations making it easier for users to engage with
    - Key players:
        - Facade Interface
        - Concrete Facade
        - Subsystem

    - Processing Order request

*/

public class _01_Facade {
    public static void main(String[] args) {

        OrderService_ orderService = new OrderService_();
        orderService.processOrder(new OrderRequest_());
    }
}

class Authentication_ {

    public void auth() {
        System.out.println("Authentication done successfully");
    }
}

class OrderRequest_ {

    private String name = "Jarvis Wuod";
    private String cardNumber = "123456";
    private int balance = 23_091;
    private String address = "1234 Street Jarvis";

    private String[] items = { "12we", "fdop", "op09", "yu78", "klnm" };

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

    public String[] getItems() {
        return items;
    }
}

class Inventory_ {

    public boolean checkInventory(String itemId) {
        return true;
    }

    public void reduceInventory(String itemId, int quantity) {
        System.out.println("Reducing item with itemId: " + itemId + " by " + quantity);
    }
}

class Payment_ {

    private String name;
    private String cardNumber;
    private int totalCost;

    public Payment_(String name, String cardNumber, int totalCost) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.totalCost = totalCost;
    }

    public void pay() {
        System.out.println("Charging card with name " + name);
    }
}

class OrderFulfillment_ {

    private Inventory_ inventory;

    public OrderFulfillment_(Inventory_ inventory) {
        this.inventory = inventory;
    }

    public void fulfill(String name, String address, String[] items) {
        System.out.println("Inserting order into database");

        for (String item : items) {
            inventory.reduceInventory(item, 1);
        }
    }
}

class OrderService_ {

    public void processOrder(OrderRequest_ order) {

        Authentication_ authentication = new Authentication_();
        authentication.auth();

        Inventory_ inventory = new Inventory_();

        for (String item : order.getItems()) {
            inventory.checkInventory(item);
        }

        Payment_ payment = new Payment_(order.getName(), order.getCardNumber(), order.getBalance());
        payment.pay();

        OrderFulfillment_ orderFulfillment = new OrderFulfillment_(inventory);
        orderFulfillment.fulfill(order.getName(), order.getCardNumber(), order.getItems());
    }
}
