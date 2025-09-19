package _04_DesignPatterns.Behavioral.Template.good.Strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            BeverageMaker beverageMaker = new BeverageMaker(new Tea(scanner));
            beverageMaker.makeBeverage();

            beverageMaker.setBeverage(new Coffee(scanner));
            beverageMaker.makeBeverage();

            beverageMaker.setBeverage(new Camomile());
            beverageMaker.makeBeverage();
        }
    }
}
