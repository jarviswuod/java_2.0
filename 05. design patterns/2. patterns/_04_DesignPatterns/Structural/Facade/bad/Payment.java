package _04_DesignPatterns.Structural.Facade.bad;

public class Payment {

    private String name;
    private String cardNumber;
    private double amount;

    public Payment(String name, String cardNumber, double amount) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public void pay() {
        System.out.println("Charging card with name " + name);
    }

}
