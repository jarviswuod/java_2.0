package _04_DesignPatterns.Behavioral.ChainOfResponsibility.good;

public class Validator extends Handler {

    @Override
    public boolean doHandle(HttpRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        request.setValidatedString(username);
        request.setValidatedPassword(password);

        System.out.println("Validation successful for " + username);

        return request.getValidatedString() == "" || request.getValidatedPassword() == "";
    }
}
