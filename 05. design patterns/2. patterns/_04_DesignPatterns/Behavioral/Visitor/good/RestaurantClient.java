package _04_DesignPatterns.Behavioral.Visitor.good;

public class RestaurantClient extends Client {

    public RestaurantClient(String name, String email) {
        super(name, email);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRestaurant(this);
    }
}
