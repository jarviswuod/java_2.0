/*

    NOTES:
    - final variable
        - You are creating a contant value
            - Example: final int AGE = 9;

    - final class
        - You are preventing Inheritance
            - Example: final class Calc {};

    - final method
        - You are preventing override of the method
            - Example: final public void add() {};

 */

public class _35_FinalKeyword {
    public static void main(String[] args) {
        final int AGE = 9;
        // AGE = 11; // ERROR -> The final local variable AGE cannot be assigned.
        System.out.println(AGE);

    }
}

class Calculator {
    final public void add(int num1) {
        System.out.println(num1);
    }
}

class AdvancedCalc extends Calculator {

    // ERROR -> Cannot override the final method
    // public void add(int num1) { }
}

final class Calc {
    final public void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}

// ERROR -> The type AdvancedCalc cannot subclass the final class Calc
// class AdvancedCalc extends Calc { }
