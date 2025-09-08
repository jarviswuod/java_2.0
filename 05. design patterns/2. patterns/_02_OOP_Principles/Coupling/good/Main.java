package _02_OOP_Principles.Coupling.good;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(new EmailSender());
        order1.placeOrder();

        Order order2 = new Order(new SmsSender());
        order2.placeOrder();
    }
}
