package _02_OopPrinciples.Coupling;

/*

    NOTES:
    - Coupling:
        - Coupling refers to the degree of dependecy between different classes
        - Higly coupling:
            - Means classes are higly interconnected making it difficult to modify or maintain them independently. Here, modifying one class, could easily break the other which could eventually break the whole program

        - Low coupling:
            - Means loose connection between classes allowing for great flexibility and ease of modification


    - BAD EXAMPLE EXPLANATION:
        - We have create an EmailSender class with a sendEmail() method. This method helps in sending email logic, it covers all the logics from connecting to the EmailServer, authenticating, sending our email message etc

                public class EmailSender {
                    public void sendEmail(String msg) {
                        // Email sending logic

                        System.out.println("Sending email: " + msg);
                    }
                }

        - We are assuming we have an ecommerce website, where a user can place an order. And say once they place an order we need to notify them of it
        - We have create an Order class with a placeOrder() method. This method covers the logic from inserting an order in the DB, reducing the stock quantity, processing payment, etc. Once that has been done, when we are sending an email to the user that the order has been placed succesfully, basic reassurance to the user

                public class Order {
                    public void placeOrder() {
                        // Place order logic

                        EmailSender emailSender = new EmailSender();
                        emailSender.sendEmail("Order placed successfully.");
                    }
                }

        - We are simulating an order placement process;
                public class Main {
                    public static void main(String[] args) {

                        Order order = new Order();
                        order.placeOrder();
                    }
                }

        - The program works fine and the user gets an email notification that an order is placed successfully

        - ISSUE:
            - In this example, the Order class is tightly coupled to the EmailSender class because it directly creates an instance of the EmailSender class, (this is by calling the 'new' keyword). This makes the Order class dependent on the implementation details of the EmailSender and any changes to the EmailSender class may require changes to the Order class too, this means we are risking bugs introduction into Order class and we'd rather not


    - GOOD EXAMPLE EXPLANATION:
        - We can reduce coupling by introducing an abstraction or interface layer between the Order and EmailSender classes. This allows the Order class interact with EmailSender class through the interface making it easier to modify or replace the implementation of EmailSender class without affecting the Order class
                public interface INotificationService {

                    void sendNotification(String msg);
                }

        - We then implement the INotificationService to EmailSender class and override the sendNotification() method replacing the sendEmail() logic
                public class EmailSender implements INotificationService {

                    @Override
                    public void sendNotification(String msg) {
                        // Email sending logic
                        System.out.println("Sending email: " + msg);
                    }
                }

        - In our Order class;
            - OLD::
                public class Order {
                    public void placeOrder() {
                        // Place order logic

                        EmailSender emailSender = new EmailSender();
                        emailSender.sendEmail("Order placed successfully.");
                    }
                }

            - REPLACEMENT::
                public class Order {
                    public void placeOrder() {
                        // Place order logic

                        EmailSender emailSender = new EmailSender();
                        emailSender.sendNotification("Order placed successfully.");
                    }
                }


        - We could replace sendEmail() with sendNotification() which works fine but we still have an issue. It's tightly coupled just as before which makes it not very flexible, coz say the user wants to be notified via text message instead when an order is placed successfully
        - Currently, the EmailSender is just hardcoded into the Order class placeorder() method. This means you can't switch out how a notification is sent to a user. This leads to adding the interface via constructor

            NEW::
                public class Order {

                    private INotificationService notificationService;

                    public Order(INotificationService notificationService) {
                        this.notificationService = notificationService;
                    }

                    public void placeOrder() {
                        notificationService.sendNotification("Order placed successfully");
                    }
                }

        - In our client area, we'll need to pass a INotificationService to an Order object when we creating Order instance. We can pass an EmailSender or introduce a new notification mechanism with easy, Example SmsSender class

                public class Main {
                    public static void main(String[] args) {

                        Order order1 = new Order(new EmailSender());
                        order1.placeOrder();

                        Order order2 = new Order(new SmsSender());
                        order2.placeOrder();
                    }
                }

        - CONCLUSION:
            - We can switch to whatever notification we want to without having to modify the Order class. Basically decoupling the Order class from the specific implementation of the NotificationService allowing different implementations. Example;
                - EmailSender or SmsSender to be easily substituted without modifying the Order class. This improves the flexibility and maintainability of the code base

 */

public class Notes {

}
