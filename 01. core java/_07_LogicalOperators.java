public class _07_LogicalOperators {

    public static void main(String args[]) {
        // && || !
        int age = 20;
        boolean hasLicense = false;

        if (age >= 18 && hasLicense == true) {
            System.out.println("You are allowed to drive");
        } else {
            System.out.println("You are not allowed to drive");
        }

        // Not operator(!)
        System.out.println(!hasLicense);
    }
}