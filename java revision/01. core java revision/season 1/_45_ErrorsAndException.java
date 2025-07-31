/*

    NOTES:

    - Types of Errors:
        1. Compile-time Error → Syntax issues detected during compilation
        2. Runtime Error → Exceptions that occur while the program is running
        3. Logical Error(bugs) → Code runs but produces incorrect results

    - Exception Handling Rule:
        - Catch more specific (child) exceptions before general (parent) ones
        - Parent exceptions (like Exception or Throwable) should be last in the catch chain
        - try { ... } catch (Exception e) { ... }

 */

public class _45_ErrorsAndException {

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
