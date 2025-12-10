package _03_Design.Structural.Facade;

import java.util.List;

/*

    NOTES:
    - Is a structural design pattern that simplifys complex interfaces encapsulating uncessary functionalities
    - Key players:
        - Facade interface
        - Concrete Facade
        - Subsystem

    - Example:
        - Order request processing: auth, validation, order request, payment, inventory, order fulfillment

*/

public class _02_Facade {
    public static void main(String[] args) {

        _02_OrderService orderService = new _02_OrderService(new _02_OrderRequest());
        orderService.processOrder();
    }
}

class _02_OrderService {

    private _02_OrderRequest request;

    public _02_OrderService(_02_OrderRequest request) {
        this.request = request;
    }

    public void processOrder() {

        _02_Validation validation = new _02_Validation(request.name, request.password);
        validation.validate();
        _02_Authentication auth = new _02_Authentication(validation.getValidatedName(), validation.getValidatedPass());
        auth.authenticate();

        _02_Inventory inventory = new _02_Inventory();
        inventory.checkInventory(request);

        _02_Payment payment = new _02_Payment();
        payment.pay(request);

        _02_OrderFulfillment fulfillment = new _02_OrderFulfillment(inventory);
        fulfillment.fulfill(request);

    }
}

class _02_Validation {

    private String name;
    private String password;

    private String validatedName;
    private String validatedPass;

    public _02_Validation(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getValidatedName() {
        return validatedName;
    }

    public String getValidatedPass() {
        return validatedPass;
    }

    public void validate() {
        if (name.isEmpty() || password.isEmpty()) {
            System.out.println("Check your name and password then try again");
            return;
        }
        validatedName = name.trim();
        validatedPass = password.trim();
    }
}

class _02_Authentication {

    private String name;
    private String password;

    public _02_Authentication(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void authenticate() {
        if (!(name.equals("admin") && password.equals("admin@1234"))) {
            System.out.println("Wrong credentials please try again");
            return;
        }
        System.out.println("Auth done successfully");
    }
}

class _02_OrderRequest {

    String name = "jarvis";
    String password = "jarvis@1234";
    String cardNumber = "21340954";
    double accountBalance = 892309;
    String address = "st jarvis 23";

    List<String> orderList = List.of("21sd", "erpo", "23jk", "78nb");

}

class _02_Inventory {

    public void checkInventory(_02_OrderRequest request) {
        for (String item : request.orderList)
            System.out.print(item + " ");

        System.out.println();
        System.out.println("Items available");
    }

    public void reduceInventory(_02_OrderRequest request, int quantity) {
        for (String item : request.orderList)
            System.out.println("Reducing " + item + " by " + quantity);
    }
}

class _02_Payment {

    public void pay(_02_OrderRequest request) {
        System.out.println("Changing your card " + request.cardNumber + " a total of 8934 amount");
    }
}

class _02_OrderFulfillment {

    private _02_Inventory inventory;

    public _02_OrderFulfillment(_02_Inventory inventory) {
        this.inventory = inventory;
    }

    public void fulfill(_02_OrderRequest request) {
        // Updating the order to the database

        // Reducing the inventory
        inventory.reduceInventory(request, 4);
        System.out.println("Sending out order to " + request.name + " at the address " + request.address);
    }
}
