package _04_DesignPatterns.Behavioral.Visitor.good;

public class RetailClient extends Client {

    public RetailClient(String name, String email) {
        super(name, email);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRetail(this);
    }
}
