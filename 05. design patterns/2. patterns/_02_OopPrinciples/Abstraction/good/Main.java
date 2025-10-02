package _02_OopPrinciples.Abstraction.good;

public class Main {
    public static void main(String[] args) {

        EmailService emailService = new EmailService();
        emailService.sendEmail();
    }
}