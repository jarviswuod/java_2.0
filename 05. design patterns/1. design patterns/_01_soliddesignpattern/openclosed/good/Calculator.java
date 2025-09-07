package _01_soliddesignpattern.openclosed.good;

public class Calculator {

    public int calculateNumber(int number1, int number2, Operation operation) {
        return operation.perform(number1, number2);
    }
}
