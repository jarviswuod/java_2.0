package _04_DesignPatterns.Behavioral.ChainOfResponsibility.bad;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
