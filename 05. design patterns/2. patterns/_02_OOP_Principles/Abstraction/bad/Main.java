package _02_OOP_Principles.Abstraction.bad;

public class Main {
    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        emailService.connect();
        emailService.authenticate();
        emailService.sendEmail();
        emailService.disconnect();
    }
}
