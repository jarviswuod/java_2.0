package _04_DesignPatterns.Behavioral.Template.goodTemplateMethod;

import java.util.Scanner;

public class Tea extends Beverage {

    private final Scanner scanner;

    public Tea(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    protected void brew() {
        System.out.println("Brewing tea for 3 minutes");
    }

    @Override
    protected void addCondiments() {
        if (customerWantsCondiments()) {
            System.out.println("Adding lemon to the tea");
        }
    }

    private boolean customerWantsCondiments() {
        System.out.print("Do you want condiments with your tea? (y/n): ");
        String input = scanner.nextLine().toLowerCase();
        return input.equals("y");
    }

}
