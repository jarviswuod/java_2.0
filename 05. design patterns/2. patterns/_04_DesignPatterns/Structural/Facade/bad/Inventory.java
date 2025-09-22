package _04_DesignPatterns.Structural.Facade.bad;

public class Inventory {

    public boolean checkInventory(String itemId) {
        return true; // just return true to keep things simple
    }

    public void reduceInventory(String itemId, int amount) {
        System.out.println("Reducing inventory of " + itemId + " by " + amount);
    }
}
