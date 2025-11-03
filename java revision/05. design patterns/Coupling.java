public class Coupling {

    public static void main(String[] args) {
        Order order = new Order();

        order.placeOrder(new Email());
        System.out.println();

        order.placeOrder(new Whatapp());

    }

}

class Order {

    void placeOrder(Nofification notification) {
        // Reduce stoke
        // Process payment

        // Notify user
        notification.send();
    }
}

interface Nofification {
    public void send();
}

class Email implements Nofification {

    @Override
    public void send() {
        System.out.println("Sending Nofication via email");
    }
}

class Whatapp implements Nofification {

    @Override
    public void send() {
        System.out.println("Sending Nofication via whatapp");
    }
}

class Sms implements Nofification {

    @Override
    public void send() {
        System.out.println("Sending Nofication via sms");
    }
}