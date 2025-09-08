package _02_OOP_Principles.Coupling.good;

public class Order {

    private INotificationService notificationService;

    public Order(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        notificationService.sendNotification("Order placed successfully");
    }
}
