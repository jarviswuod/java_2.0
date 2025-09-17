package _04_DesignPatterns.Behavioral.Interpreter.good;

public class Main {
    public static void main(String[] args) {

        String input = "1 + 2 * 3";

        Context context = new Context();
        Interpreter interpreter = new Interpreter(context);
        int result = interpreter.interpret(input);

        System.out.println("Result: " + result);
    }
}
