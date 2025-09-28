package _01_solid.OCP.bad;

public class Calculator {

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