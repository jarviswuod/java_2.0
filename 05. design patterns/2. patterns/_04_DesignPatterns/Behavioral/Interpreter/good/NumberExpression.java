package _04_DesignPatterns.Behavioral.Interpreter.good;

public class NumberExpression implements Expression {

    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public NumberExpression(String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public int interpret(Context context) {
        return number;
    }

}
