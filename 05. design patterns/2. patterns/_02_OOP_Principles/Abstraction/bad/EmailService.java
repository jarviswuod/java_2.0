package _02_OOP_Principles.Abstraction.bad;

public class EmailService {
    public void sendEmail() {
        System.out.println("Sending email...");
    }

    public void connect() {
        System.out.println("Connecting to email server...");
    }

    public void authenticate() {
        System.out.println("Authenticating....");
    }

    public void disconnect() {
        System.out.println("disconnecting from email server...");
    }
}
