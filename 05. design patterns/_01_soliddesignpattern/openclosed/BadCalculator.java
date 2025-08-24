package _01_soliddesignpattern.openclosed;

/*

    NOTES:
    - This is bad design where we are taking type and for each type we are having cases
    - If we introduce divion, we have to modify calculator

 */

public class BadCalculator {
    public int calcualatedNumber(int number1, int number2, String type) {

        int result = 0;

        switch (type) {
            case "sum":
                result = number1 + number2;
                break;
            case "sub":
                result = number1 - number2;
                break;

            default:
                result = 0;
                break;
        }
        return result;
    }
}