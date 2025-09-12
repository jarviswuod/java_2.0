package _04_DesignPatterns.Behavioral.Template.bad;

import java.util.Scanner;

public class Coffee {

    public void makeBeverage() {
        boilingWater();
        pourWaterIntoCup();
        brew();
        addCondiments();
    }

    private void boilingWater() {
        System.out.println("Boiling water");
    }

    private void pourWaterIntoCup() {
        System.out.println("Pouring water into cup");
    }

    private void brew() {
        System.out.println("Brewing coffee for 5 minutes");
    }

    private void addCondiments() {
        if (customerWantsCondiments()) {
            System.out.println("Adding cream to the coffee");
        }
    }

    private boolean customerWantsCondiments() {
        System.out.println("Would you like cream in your coffee? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        scanner.close();
        return input.equals("y");
    }
}
