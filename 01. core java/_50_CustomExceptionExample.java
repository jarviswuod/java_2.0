/*
 * Create a custom exception by extending the Exception class
 * You create a constructor passing Stringm essage
 * You call the super keyword with the msg coz you calling the parent class constructor of the Exception with the msg you want returned
 * 
 * NOTE:
 * -> For custom Exception you should extend the parent Exception [Exception]
 * -> If you are accepting a message you have to pass the message to the constructor
 * 
 */

class CustomNameException extends Exception {
    public CustomNameException(String msg) {
        super(msg);
    }
}

public class _50_CustomExceptionExample {
    public static void main(String[] args) {

        int i = 0;
        int j = 0;

        try {

            if (i == 0)
                throw new CustomNameException("Division by zero is not allowed");

            j = 18 / i;

        } catch (CustomNameException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        }

        System.out.println("Final value of j: " + j);
    }
}