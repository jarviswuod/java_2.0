/*
 * final variable
 * You are creating a contant value
 */

/*
 * final class
 * You are preventing Inheritance
 */

/*
 * final method
 * You are preventing override of the method
 */

public class _30_FinalKeyword {
    public static void main(String[] args) {
        final int AGE = 9; // Uppcase because it's a now contant value
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

    // public void add(int num1) { // ERROR -> Cannot override the final method
    // System.out.println(num1);
    // }
}

final class Calc {
    final public void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}

// class AdvancedCalc extends Calc {
// } // ERROR -> The type AdvancedCalc cannot subclass the final class Calc
