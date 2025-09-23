package _04_DesignPatterns.Structural.Facade.good;

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
