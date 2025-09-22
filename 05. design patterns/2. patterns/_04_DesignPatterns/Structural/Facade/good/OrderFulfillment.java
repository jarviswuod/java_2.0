package _04_DesignPatterns.Structural.Facade.good;

public class OrderFulfillment {

    private Inventory inventory;

    public OrderFulfillment(Inventory inventory) {
        this.inventory = inventory;
    }

    public void fulfill(String name, String address, String[] items) {
        System.out.println("Inserting order into database");

        for (String item : items) {
            inventory.reduceInventory(item, 1);
        }
    }
}
