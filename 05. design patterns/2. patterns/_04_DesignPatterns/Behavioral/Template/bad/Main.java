package _04_DesignPatterns.Behavioral.Template.bad;

public class Main {
    public static void main(String[] args) {

        Tea tea = new Tea();
        tea.makeBeverage();

        System.out.println();

        Coffee coffee = new Coffee();
        coffee.makeBeverage();
    }
}
