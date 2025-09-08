package _02_OopPrinciples.Coupling.good;

public class Order {

    private INotificationService notificationService;

    public Order(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        notificationService.sendNotification("Order placed successfully");
    }
}
