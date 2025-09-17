package _04_DesignPatterns.Behavioral.Visitor.bad;

public class LawClient extends Client {

    public LawClient(String name, String email) {
        super(name, email);
    }

    @Override
    public void sendEmail() {
        System.out.println("Sending law marketing tips to " + name + " at " + email);
    }

}
