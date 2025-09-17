package _04_DesignPatterns.Behavioral.ChainOfResponsibility.bad;

public class Validator {

    public void validate(HttpRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        // Trim whitespaces
        request.setValidatedString(username.trim());
        request.setValidatedPassword(password.trim());

    }
}
