package _02_OopPrinciples.Coupling.good;

public class SmsSender implements NotificationService {

    @Override
    public void sendNotification(String msg) {
        // Email sending logic

        System.out.println("Sms message email: " + msg);
    }
}
