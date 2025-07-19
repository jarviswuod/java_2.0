/*
    Data Types Supported:
        - String, byte, short, int, char -> Wrapper classes (Byte, Short, Integer, Character)
        - Enum types
        - NOT SUPPORTED -> float, double, long, boolean
 */

/*
    switch (expression) {
        case value1:
            // code block
            break;
        case value2:
            // code block
            break;
        default:
            // default code block
    }
 */

public class _10_SwithStatement {

    public static void main(String[] args) {

        String day = "Sa";
        switch (day) {
            case "Mon":
                System.out.println("Today is a Monday");
                break;
            case "Tue":
                System.out.println("Today is a Tueday");
                break;
            case "Wed":
                System.out.println("Today is a Wednesday");
                break;
            case "Thur":
                System.out.println("Today is a Thursday");
                break;
            case "Fri":
                System.out.println("Today is a Friday");
                break;
            case "Sat":
                System.out.println("Today is a Saturday");
                break;
            case "Sun":
                System.out.println("Today is a Sunday");
                break;

            default:
                System.out.println("Day Entered is invalid");
                break;
        }
    }
}