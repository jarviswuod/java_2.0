/*
    Errors
    bug - Different output than expected
    runtime - when running the code
    complite time - when coding

    Exception class at the bottom after calling other staffs

 */

public class _45_ErrorsAndExceptions {

    public static void main(String[] args) {

        try {
            int age = 5;
            int ans = age / 10;
            System.out.println("ans :" + ans);

            int[] ages = new int[2];
            ages[0] = 12;
            ages[1] = 21;
            ages[3] = 321;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero dawg: NOPE");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("I said Out of bound lol");
        } catch (Exception e) {
            System.out.println("Cathing any left out error/ Unhandled Exceptions " + e);
        }
    }
}