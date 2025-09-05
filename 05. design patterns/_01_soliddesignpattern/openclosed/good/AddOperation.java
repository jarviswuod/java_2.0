package _01_soliddesignpattern.openclosed.good;

public class AddOperation implements Operation {

    @Override
    public int perform(int number1, int number2) {
        return number1 + number2;
    }
}