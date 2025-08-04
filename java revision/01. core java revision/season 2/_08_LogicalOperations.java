/*
 
    OFFHEAD:
    ( && ) -> AND
    ( || ) -> OR
    ( ! ) -> NOT

 */

public class _08_LogicalOperations {
    public static void main(String[] args) {

        boolean raining = true;
        boolean hasUmbrella = true;

        if (raining && hasUmbrella) {
            System.out.println("Carry yout umbrella");
        } else {
            System.out.println("You will be rained on heavily");
        }

    }
}
