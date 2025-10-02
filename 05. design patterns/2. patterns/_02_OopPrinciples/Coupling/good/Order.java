package _02_OopPrinciples.Coupling.good;

public class Order {

    private NotificationService notificationService;

    public Order(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        notificationService.sendNotification("Order placed successfully");
    }
}
