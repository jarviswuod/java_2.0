public class _09_TenaryOperator {

    public static void main(String[] args) {

        /*
         * Tenary operation template
         * 
         * (expression) ? 'If condition is true execute this' : 'else execute this'
         * 
         */

        int age = 20;
        String results = age >= 18 ? "You are an adult" : "You are still a kid";

        System.out.println(results);
    }
}