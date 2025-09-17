package _04_DesignPatterns.Behavioral.Visitor.good;

public interface Visitor {

    void visitLaw(LawClient lawClient);

    void visitRestaurant(RestaurantClient restaurantClient);

    void visitRetail(RetailClient retailClient);
}
