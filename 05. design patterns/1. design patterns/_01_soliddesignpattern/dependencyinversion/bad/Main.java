package _01_soliddesignpattern.dependencyinversion.bad;

public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        int output = calc.calcualate(12, 24, "add");

        System.out.println(output);
    }
}
