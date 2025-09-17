package _04_DesignPatterns.Behavioral.Visitor.bad;

public class RestaurantClient extends Client {

    public RestaurantClient(String name, String email) {
        super(name, email);
    }

    @Override
    public void sendEmail() {
        System.out.println("Sending Restaurant marketing tips to " + name + " at " + email);
    }
}
