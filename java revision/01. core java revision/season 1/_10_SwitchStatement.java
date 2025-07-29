/*
    OFFHEAD NOTES:
      switch(condition) {

        case firstValue:
            execute block
        break;
        case secondValue:
            execute block
        break;
        case thirdValue:
            execute block
        break;
        default:
            execute block
        break;
      }
    
    Data Types Supported:
        - String, char, int, enum

   Data Types NOT Supported:
        - float, double, long, boolean

 */

public class _10_SwitchStatement {

    public static void main(String[] args) {

        int day = 8;

        switch (day) {
            case 1:
                System.out.println("Today is a Monday");
                break;
            case 2:
                System.out.println("Today is a Tuesday");
                break;
            case 3:
                System.out.println("Today is a Wednesday");
                break;
            case 4:
                System.out.println("Today is a Thursday");
                break;
            case 5:
                System.out.println("Today is a Friday");
                break;
            case 6:
                System.out.println("Today is a Saturday");
                break;
            case 7:
                System.out.println("Today is a Sunday");
                break;
            default:
                System.out.println("Today is a Unknown day");
                break;
        }
    }
}
