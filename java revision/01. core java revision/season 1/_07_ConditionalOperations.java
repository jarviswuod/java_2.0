/*

    OFFHEAD NOTES:
    --------------------- Sample 1
    
    if(condition) {
         // execute block
    }

    --------------------- Sample 2

    if(condition) {
         // execute block
    } else{
         // execute block
    }

    --------------------- Sample 3

    if(condition) {
         // execute block
    } else if(condition) {
         // execute block
    } else {
         // execute block
    }

 */

public class _07_ConditionalOperations {

    public static void main(String[] args) {
        boolean raining = false;

        if (raining) {
            System.out.println("Carry an umbrella");
        } else {
            System.out.println("Carry a water bottle");
        }
    }
}
