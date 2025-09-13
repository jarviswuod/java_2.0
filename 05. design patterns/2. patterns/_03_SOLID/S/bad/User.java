package _03_SOLID.S.bad;

public class User {

    private String username;
    private String email;

    public void register(String email) {
        // Register user logic ...

        // Send email
        EmailSender emailSender = new EmailSender();

        emailSender.sendEmail(email, "Welcome to our plaform");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}