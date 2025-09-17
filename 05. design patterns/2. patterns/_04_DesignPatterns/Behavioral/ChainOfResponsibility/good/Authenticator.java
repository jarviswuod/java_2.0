package _04_DesignPatterns.Behavioral.ChainOfResponsibility.good;

public class Authenticator extends Handler {

    @Override
    public boolean doHandle(HttpRequest request) {
        String username = request.getValidatedString();
        String password = request.getValidatedPassword();

        System.out.println("Authenticating " + username);

        return !("admin".equals(username) && "admin@123".equals(password));
    }

}
