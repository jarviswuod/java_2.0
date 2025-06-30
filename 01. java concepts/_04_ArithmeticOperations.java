public class _04_ArithmeticOperations {

    public static void main(String args[]) {
        // + - * / %
        // Operation precendence
        int num1 = 12;
        int num2 = 9;

        int total = num1 + num2;
        int difference = num1 - num2;
        int multiple = num1 * num2;
        int div = num1 / num2;
        int modular = num1 % num2;

        System.out.println("total : " + total);
        System.out.println("difference : " + difference);
        System.out.println("multiple : " + multiple);
        System.out.println("division : " + div);
        System.out.println("modular : " + modular);

    }
}