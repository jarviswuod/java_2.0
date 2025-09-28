package _01_solid.DIP.good;

public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        int outputAdd = calc.calcualate(24, 12, new AddOperation());
        int outputMin = calc.calcualate(24, 12, new SubOperation());

        System.out.println(outputAdd);
        System.out.println(outputMin);

    }
}