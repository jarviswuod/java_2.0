package _04_DesignPatterns.Behavioral.ChainOfResponsibility.bad;

public class Authenticator {

    public boolean authenticate(HttpRequest request) {
        String username = request.getValidatedString();
        String password = request.getValidatedPassword();

        System.out.println("Authenticating " + username);

        return "admin".equals(username) && "admin@123".equals(password);
    }
}
