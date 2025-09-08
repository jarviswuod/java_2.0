package _02_OopPrinciples.Coupling;

/*

    NOTES:
    - Coupling refers to the degree of dependecy between different classes.
    - Higly coupling means classes are higly interconnected making it difficult to modify or maintain them independently
        - Here, modifying one class, coult easily break the other which could eventually break the whole program
    - Low coupling means, loose connection between classes allowing for great flexibility and ease of modification


    - BAD EXAMPLE EXPLANATION:
        - We have create a class EmailSender with a sendEmail() method, to help in sending email logic; covering all the things from connecting to the email server, authenticating, etc

            public class EmailSender {

                public void sendEmail(String msg) {
                    // Email sending logic

                    System.out.println("Sending email: " + msg);
                }
            }

        - We are assuming we have an ecommerce website, where a user can place an order, and say once they place an order we need to notify them of it. Here the logic is inserting the order in the DB, reducing the stock quantity, processing payment, etc. Once that has been done, when we are sending an email to a user that the order has been placed succesfully, basically reassuring the user.

            public class Order {
                public void placeOrder() {
                    // Place order logic

                    EmailSender emailSender = new EmailSender();
                    emailSender.sendEmail("Order placed successfully.");
                }
            }

        - We are simulating an order placement process;
            public static void main(String[] args) {
                Order order = new Order();
                order.placeOrder();
            }
            
        - The program works fine and the user gets an email notification that an order is placed successfully

        - ISSUE:
            - In this example the order class is tightly coupled to the EmailSender class because it directly creates an instance of the EmailSender class, (this is by calling the 'new' keyword)
            This makes the Order class dependent on the implementation details of the EmailSender and any changes to the EmailSender class may require changes to the Order class too, this means we are risking bugs introduction into the class and we'd rather not

    - GOOD EXAMPLE EXPLANATION:
        - We can reduce coupling by introducing an abstraction or interface btwn the Order and EmailSender classes and this allows the Order class interact with the EmailSender class through an abstraction or interface making it easier to modify or replace the implementation of EmailSender class without affecting the orde class
            public interface INotificationService {
                void sendNotification(String msg);
            }

        - We can not implement the INotificationService to EmailSender class then override the sendNotification() method with sendEmail() logic
            public class EmailSender implements INotificationService {

                @Override
                public void sendNotification(String msg) {
                    // Email sending logic
                    System.out.println("Sending email: " + msg);
                }
            }

        - In our Order class;
            OLD::
                public class Order {
                    public void placeOrder() {
                        // Place order logic

                        EmailSender emailSender = new EmailSender();
                        emailSender.sendEmail("Order placed successfully.");
                    }
                }

            REPLACEMENT::
                public class Order {
                    public void placeOrder() {
                        // Place order logic

                        EmailSender emailSender = new EmailSender();
                        emailSender.sendNotification("Order placed successfully.");
                    }
                }


        - We could replace sendEmail() with sendNotification(), it works fine but we still have an issue; it's still tightly coupled just as before which makes it not very flexible, coz say the user wants to be notified via text msg instead when his/her order is placed successfully, there is not way of doing that because the EmailSender is just hardcoded into the Order class placeorder() method. This means no switching out the way we send a notification to a user. This leads to adding the interface at this level too, via constructor

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

        - In our client area, we not need to pass a INotificationService to any Order object when we creating Order objects. We can pass an EmailSender or introduce a new notification mechanism with easy, say sms
            public static void main(String[] args) {
                Order order1 = new Order(new EmailSender());
                order1.placeOrder();

                Order order2 = new Order(new SmsSender());
                order2.placeOrder();
            }

        - This is all possible because we mentioned that we need any INotificationService when creating our Order and we already have an abstraction interface (INotificationService) to implement from

        - We can switch to whatever notification we want to without having to modifythe Order class, We have decoupled the Order class from the specific implmentation of the notification swervice allowing different implementations example EmailSender or SmsSender to be easily substituted without modifying the Order class. This reduces decoupling and imporives the flexibility and maintainability of the code base

 */

public class Notes {

}
