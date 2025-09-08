package _02_OopPrinciples.Coupling.bad;

public class Order {
    public void placeOrder() {
        // Place order logic

        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail("Order placed successfully.");
    }
}
