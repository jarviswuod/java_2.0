package _04_DesignPatterns.Behavioral.Interpreter.good;

public class Interpreter {

    private Context context;

    public Interpreter(Context context) {
        this.context = context;
    }

    public int interpret(String expression) {
        Expression expressionTree = BuildExpressionTree(expression);
        return expressionTree.interpret(context);
    }

    private Expression BuildExpressionTree(String input) {
        input = "1 + 2 * 3";
        Expression expressionTree = new AdditionExpression(
                new MultiplicationExpression(
                        new NumberExpression("2"),
                        new NumberExpression("3")),
                new NumberExpression("1")

        );

        return expressionTree;
    }
}
