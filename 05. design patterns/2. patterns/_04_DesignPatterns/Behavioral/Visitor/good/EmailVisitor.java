package _04_DesignPatterns.Behavioral.Visitor.good;

public class EmailVisitor implements Visitor {

    @Override
    public void visitLaw(LawClient lawClient) {
        System.out.println("Sending law marketing tips to " + lawClient.name + " at " + lawClient.email);
    }

    @Override
    public void visitRestaurant(RestaurantClient restaurantClient) {
        System.out.println(
                "Sending Restaurant marketing tips to " + restaurantClient.name + " at " + restaurantClient.email);
    }

    @Override
    public void visitRetail(RetailClient retailClient) {
        System.out.println("Sending retail marketing tips to " + retailClient.name + " at " + retailClient.email);
    }
}
