package _04_DesignPatterns.Behavioral.Visitor.good;

public abstract class Client {

    protected String name;
    protected String email;

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public abstract void accept(Visitor visitor);
}
