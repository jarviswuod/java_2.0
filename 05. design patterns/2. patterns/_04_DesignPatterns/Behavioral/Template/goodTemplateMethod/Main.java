package _04_DesignPatterns.Behavioral.Template.goodTemplateMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            Tea tea = new Tea(scanner);
            tea.prepare();

            System.out.println();

            Camomile camomile = new Camomile();
            camomile.prepare();
        }
    }
}
