package _04_DesignPatterns.Behavioral.Visitor.good;

public class PDFExportVisitor implements Visitor {

    @Override
    public void visitLaw(LawClient lawClient) {
        System.out.println("Sending law marketing tips to " + lawClient.name + " at " + lawClient.email);
    }

    @Override
    public void visitRestaurant(RestaurantClient restaurantClient) {
        System.out.println("Exporting restaurant client " + restaurantClient.name + " to PDF");
    }

    @Override
    public void visitRetail(RetailClient retailClient) {
        System.out.println("Exporting retail client " + retailClient.name + " to PDF");
    }
}
