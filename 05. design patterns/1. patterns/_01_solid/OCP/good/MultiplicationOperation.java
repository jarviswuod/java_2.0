package _01_solid.OCP.good;

public class MultiplicationOperation implements Operation {

    @Override
    public int perform(int number1, int number2) {
        return number1 * number2;
    }
}