package _02_OopPrinciples.Coupling.good;

public class EmailSender implements NotificationService {

    @Override
    public void sendNotification(String msg) {
        // Email sending logic

        System.out.println("Sending email: " + msg);
    }
}
