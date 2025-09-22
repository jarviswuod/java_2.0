package _04_DesignPatterns.Structural.Facade.good;

public class Main {
    public static void main(String[] args) {

        OrderRequest orderRequest = new OrderRequest();
        OrderService orderService = new OrderService();
        orderService.order(orderRequest);
    }
}
