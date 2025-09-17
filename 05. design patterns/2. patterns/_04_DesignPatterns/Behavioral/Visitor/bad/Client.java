package _04_DesignPatterns.Behavioral.Visitor.bad;

public abstract class Client {

    protected String name;
    protected String email;

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract void sendEmail();
}
