/*
 condition? "execute this part if condition is true": "execute this part if condition is false";
 */

public class _09_TenaryOperator {

    public static void main(String[] args) {
        boolean condition = true;

        String output = condition ? "First part executed" : "Second part executed";

        System.out.println(output);

    }
}
