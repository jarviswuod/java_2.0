package _02_OOP_Principles.Abstraction.good;

public class EmailService {
    public void sendEmail() {
        connect();
        authenticate();
        System.out.println("Sending email...");
        disconnect();
    }

    private void connect() {
        System.out.println("Connecting to email server...");
    }

    private void authenticate() {
        System.out.println("Authenticating....");
    }

    private void disconnect() {
        System.out.println("disconnecting from email server...");
    }
}
