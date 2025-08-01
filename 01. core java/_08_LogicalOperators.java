/*

    NOTES:
    - Logical operations
         - AND represented by: &&
         - OR represented by: ||
         - NOT represented by: !

 */

public class _08_LogicalOperators {

    public static void main(String args[]) {

        int age = 20;
        boolean hasLicense = false;

        if (age >= 18 && hasLicense == true) {
            System.out.println("You are allowed to drive");
        } else {
            System.out.println("You are not allowed to drive");
        }

        // Not operator(!) example
        System.out.println(!hasLicense);
    }
}