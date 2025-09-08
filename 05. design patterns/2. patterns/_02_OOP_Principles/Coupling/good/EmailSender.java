package _02_OOP_Principles.Coupling.good;

public class EmailSender implements INotificationService {

    @Override
    public void sendNotification(String msg) {
        // Email sending logic

        System.out.println("Sending email: " + msg);
    }

}
