/*
    OFFHEAD NOTES:
      - AND operator -> &&
      - OR operator -> ||
      - NOT operator -> !

 */

public class _08_LogicalOperator {

    public static void main(String[] args) {

        boolean raining = true;
        boolean haveUmbrella = true;

        if (raining && haveUmbrella) {
            System.out.println("Carry your umbrella");
        }

        if (raining || haveUmbrella) {
            System.out.println("Consider carrying an umbrealla");
        }

        if (!raining) {
            System.out.println("Carry a water bottle");
        }
    }
}