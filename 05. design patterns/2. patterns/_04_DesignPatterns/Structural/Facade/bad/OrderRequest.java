package _04_DesignPatterns.Structural.Facade.bad;

// Request object containing user-submitted data
public class OrderRequest {

    public String name = "Danny";
    public String cardNumber = "1234";
    public double amount = 20.99;
    public String address = "123 Springfield Way, Texas";

    // item ids user wants to order
    public String[] itemIds = { "123", "456", "555", "989" };
}
