package _01_soliddesignpattern.openclosed;

/*

    NOTES:
    - No modifications in our calcualator fucntionality
    - We can keep adding extension by creating new operations

 */

public class GoodCalculator {
    public int calcualatedNumber(int number1, int number2, Operation operation) {
        return operation.perform(number1, number2);
    }
}
