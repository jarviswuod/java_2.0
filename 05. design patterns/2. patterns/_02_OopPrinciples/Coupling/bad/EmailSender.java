package _02_OopPrinciples.Coupling.bad;

public class EmailSender {

    public void sendEmail(String msg) {
        // Email sending logic

        System.out.println("Sending email: " + msg);
    }

}
