public class _06_LogicalOperators {

    public static void main(String args[]) {
        // && || !
        int age = 20;
        boolean hasLicense = true;

        if (age >= 18 && hasLicense == true) {
            System.out.println("You are allowed to drive");
        } else {
            System.out.println("You are not allowed to drive");
        }

    }
}