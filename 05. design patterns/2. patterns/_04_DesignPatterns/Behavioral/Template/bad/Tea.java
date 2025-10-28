package _04_DesignPatterns.Behavioral.Template.bad;

import java.util.Scanner;

public class Tea {

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
        System.out.println("Brewing tea for 3 minutes");
    }

    private void addCondiments() {
        if (customerWantsCondiments()) {
            System.out.println("Adding lemon to the tea");
        }
    }

    private boolean customerWantsCondiments() {
        System.out.println("Do you want condiments in your tea? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        scanner.close();
        return input.equals("y");
    }
}
