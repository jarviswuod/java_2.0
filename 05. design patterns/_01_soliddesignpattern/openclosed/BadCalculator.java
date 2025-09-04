package _01_soliddesignpattern.openclosed;

/*

    NOTES:
    - This is bad design where we are taking type and for each type we are having cases
    - If we introduce division, we have to modify calculator

    - In this calulator we are passing 2 numbers and in those 2 number we are also passing a type/ what we want to do. With a switch statement we ae doing everything, i.e if you passing the sum we are doing the addition and if you pass sub we are doing the subtraction action to the numbers. For each action we want we are passing the type 
    - Now suppose we want to add new operation like multiplication or division, then we need to come here and modify out code, that's a violation of our open-closed principle, we should not be allowed class/objects that has been created, we should only allow to extend it
    - We overcome this scenario in the good calculator

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