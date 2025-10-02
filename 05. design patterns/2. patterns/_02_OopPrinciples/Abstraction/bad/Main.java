package _02_OopPrinciples.Abstraction.bad;

public class Main {
    public static void main(String[] args) {

        EmailService emailService = new EmailService();

        emailService.connect();
        emailService.authenticate();
        emailService.sendEmail();
        emailService.disconnect();
    }
}
