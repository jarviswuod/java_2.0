/*

    NOTES:
       - Types of Errors:
           1. Compile-time Error → Syntax issues detected during compilation
           2. Runtime Error → Exceptions that occur while the program is running
           3. Logical Error(bugs) → Code runs but produces incorrect results

       - Exception Handling Rule:
           - Catch more specific (child) exceptions before general (parent) ones
           - Parent exceptions (like Exception or Throwable) should be last in the catch chain
       - Exception Handling Syntax:
           - try {...} catch (SpecificException e) {...} catch (AnotherException e) {...} catch (Exception e) {...}

 */

public class _48_ErrorsAndExceptions {
    public static void main(String[] args) {

        int i = 2;
        int j = 0;

        int nums[] = new int[5];

        try {
            j = 18 / i;
            System.out.println(nums[1]);
            System.out.println(nums[5]);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Stay in array limit");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

        System.out.println(j);

    }
}