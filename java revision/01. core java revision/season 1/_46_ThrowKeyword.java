/*

    OFFHEAD NOTE:
        - `throw` is used to explicitly throw an exception
        - Used for manual/custom exception handling
        - Syntax: throw new ExceptionType("Custom Message");

 */

public class _46_ThrowKeyword {

    public static void main(String[] args) {

        try {
            int age = 5;
            int divideBy = 4;
            if (divideBy == 0) {
                throw new ArithmeticException("NOT by zero chief");
            }
            double ans = age / divideBy;

            System.out.println("ans :" + ans);

            int[] ages = new int[2];

            int index = 3;

            if (index > ages.length) {
                throw new ArrayIndexOutOfBoundsException("That probably too much");
            }

            ages[0] = 12;
            ages[1] = 21;
            ages[index] = 321;

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero dawg: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("I said Out of bound lol: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Cathing any left out error/ Unhandled Exceptions " + e);
        }
    }
}
