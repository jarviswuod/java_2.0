package _03_Design.Behavior.ChainOfRes;

/*

    NOTES:
    - Is a behavioral pattern that chain a group of objects where a request can either be processed by an object or passed to the next object
    - Key Players:
        - Element interface
        - Concrete Element
    - Example:
        - Validation -> Authorization -> Logging

*/

public class _02_ChainOfRes {
    public static void main(String[] args) {

        _02_HttpRequest request = new _02_HttpRequest("admin ", "admin@1234");

        _02_Validation_ validation = new _02_Validation_(request);
        _02_Authentication_ authentication = new _02_Authentication_(request);
        _02_Logging_ logging = new _02_Logging_(request);

        validation.nextObj(authentication).nextObj(logging);
        validation.handle();
    }
}

abstract class _02_Element {

    protected _02_HttpRequest request;
    private _02_Element next;

    public _02_Element(_02_HttpRequest request) {
        this.request = request;
    }

    public _02_Element nextObj(_02_Element element) {
        this.next = element;
        return element;
    }

    public void handle() {
        if (!doHandle())
            return;

        if (next != null)
            next.handle();
    }

    public abstract boolean doHandle();

}

class _02_Validation_ extends _02_Element {

    public _02_Validation_(_02_HttpRequest request) {
        super(request);
    }

    public boolean doHandle() {
        System.out.println("Validation on it's way");

        if (request.getPassword().isEmpty() || request.getUsername().isEmpty())
            return false;

        request.setValidPassword(request.getPassword().trim());
        request.setValidUsername(request.getUsername().trim());
        return true;
    }
}

class _02_Authentication_ extends _02_Element {

    public _02_Authentication_(_02_HttpRequest request) {
        super(request);
    }

    public boolean doHandle() {
        System.out.println("Authentication is working great");
        return request.getValidUsername().equals("admin") && request.getValidPassword().equals("admin@1234");
    }
}

class _02_Logging_ extends _02_Element {

    public _02_Logging_(_02_HttpRequest request) {
        super(request);
    }

    @Override
    public boolean doHandle() {
        System.out.println("Always returnitn true mf");
        return true;
    }
}

class _02_HttpRequest {

    private String username;
    private String password;

    private String validUsername;
    private String validPassword;

    public _02_HttpRequest(String username, String password) {
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

    public String getValidUsername() {
        return validUsername;
    }

    public void setValidUsername(String validUsername) {
        this.validUsername = validUsername;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }

    @Override
    public String toString() {
        return "_02_HttpRequest [username=" + username + ", password=" + password + "]";
    }
}
