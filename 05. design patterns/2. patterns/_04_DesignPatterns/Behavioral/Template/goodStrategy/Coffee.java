package _04_DesignPatterns.Behavioral.Template.goodStrategy;

import java.util.Scanner;

public class Coffee implements IBeverage {

    private final Scanner scanner;

    public Coffee(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void prepare() {
        brew();
        addCondiments();
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
        String input = scanner.nextLine().toLowerCase();
        return input.equals("y");

    }
}
