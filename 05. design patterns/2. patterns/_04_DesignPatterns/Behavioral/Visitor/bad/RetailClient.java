package _04_DesignPatterns.Behavioral.Visitor.bad;

public class RetailClient extends Client {

    public RetailClient(String name, String email) {
        super(name, email);
    }

    @Override
    public void sendEmail() {
        System.out.println("Sending retail marketing tips to " + name + " at " + email);
    }
}
