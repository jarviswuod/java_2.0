package _04_DesignPatterns.Creational.FactoryMethod.bad.solution1;

import java.util.HashMap;
import java.util.Map;

import _04_DesignPatterns.Creational.FactoryMethod.bad.solution1.MVCFramework.Controller;

public class OrdersController extends Controller {

    public void listOrders() {

        Map<String, Object> orders = new HashMap<>();
        orders.put("Red socks", "$12.98");
        orders.put("Black socks", "$12.98");
        orders.put("Pink T-shirt", "$29.00");

        render("orders.blade.php", orders);
    }

    public void getOrder(int id) {

        // Simulating getting single order by id from db
        Map<String, Object> orders = new HashMap<>();
        orders.put("Red socks", "$12.98");

        render("order.blade.php", orders);
    }

}
