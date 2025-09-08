package _03_SOLID.S.good;

public class UserService {

    public void register(User user) {
        // Register user logic ...

        // Send email
        EmailSender emailSender = new EmailSender();

        emailSender.sendEmail(user.getEmail(), "Welcome to our plaform");
    }
}
