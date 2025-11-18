package _04_DesignPatterns.Behavioral.ChainOfResponsibility.good;

public class HttpRequest {

    private String username;
    private String password;

    public String validatedString;
    public String validatedPassword;

    public HttpRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getValidatedString() {
        return validatedString;
    }

    public void setValidatedString(String validatedString) {
        this.validatedString = validatedString;
    }

    public String getValidatedPassword() {
        return validatedPassword;
    }

    public void setValidatedPassword(String validatedPassword) {
        this.validatedPassword = validatedPassword;
    }
}