/*
 condition

    switch(condition){
        case firstcase:
            code block
            breeak;
        case secondCase:
            code block
            break;
        case thirdCase:
            code block
            break;
        default:
            code block
            break;
    }

 */

public class _10_SwithStatement {

    public static void main(String[] args) {
        int day = 0;

        switch (day) {
            case 1:
                System.out.println("Sunday");
                break;

            default:
                System.out.println("Not found");
                break;
        }
    }
}
