package _02_OopPrinciples.Coupling.bad;

public class Main {
    public static void main(String[] args) {

        Order order = new Order();
        order.placeOrder();
    }
}
