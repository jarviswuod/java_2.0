package _01_soliddesignpattern.openclosed.good;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int subValue = calculator.calculateNumber(24, 12, new SubstractOperation());
        int addValue = calculator.calculateNumber(12, 24, new AddOperation());
        int multiValue = calculator.calculateNumber(12, 24, new MultiplicationOperation());
        int divideValue = calculator.calculateNumber(24, 12, new DivisionOperation());

        System.out.println("Substraction : " + subValue + " Addition : " + addValue + " Multiplication : " +
                multiValue + " Division : " + divideValue);
    }
}