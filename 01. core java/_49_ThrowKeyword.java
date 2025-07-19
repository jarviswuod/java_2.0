public class _49_ThrowKeyword {

    public static void main(String[] args) {

        int i = 0;
        int j = 0;

        try {

            // Check for division by zero BEFORE attempting division
            if (j == 0)
                throw new ArithmeticException("Not by 0");

            j = 18 / i;

        } catch (ArithmeticException e) {
            j = 18 / 1;
            System.out.println("That's the default output " + e);

        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        }

        System.out.println(j);

    }
}