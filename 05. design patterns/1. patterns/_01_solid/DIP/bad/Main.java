package _01_solid.DIP.bad;

public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        int output = calc.calcualate(12, 24, "add");

        System.out.println(output);
    }
}
