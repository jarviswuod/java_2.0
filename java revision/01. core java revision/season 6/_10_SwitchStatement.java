/*

    NOTES:
    swith(condition) {
        case 1:
            // execute this
            break;

        case 2:
            // execute this
            break;

        default:
           break;
    }

 */

public class _10_SwitchStatement {
    public static void main(String[] args) {
        int day = 0;
        switch (day) {
            case 1:
                System.out.println("Sunday");
                break;

            case 2:
                System.out.println("Monday");
                break;

            default:
                System.out.println("Oops! No such day");
                break;
        }
    }
}
