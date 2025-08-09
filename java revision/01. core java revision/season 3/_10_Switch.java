/*
 swith(condition){
    case 1:
        code block
    break;
    case 2:
        code block
    break;
    default:
        code block
    break;

    }
 */

public class _10_Switch {
    public static void main(String[] args) {

        int day = 0;
        switch (day) {
            case 1:
                System.out.println("code block 1");
                break;
            case 2:
                System.out.println("code block 2");
                break;
            default:
                System.out.println("code block NOT");
                break;
        }
    }
}
