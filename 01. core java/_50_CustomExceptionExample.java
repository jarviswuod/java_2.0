/*

    NOTE:
        - For custom Exception you should extend the parent Exception class
        - super() keyword with message calls the parent class Exception constructor to return the message
        
    HOW TO CREATE A CUSTOM EXCEPTION:
        1. Create a custom exception by extending the Exception class
        2. Create a constructor passing String message
        3. Call the super keyword with message

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