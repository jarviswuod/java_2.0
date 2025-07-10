/*
 * Erros and Types
 * 1. Compli-time error <Syntax>
 * 2. Runtime error <Exceptions>
 * 3. Logical error <bugs>
 * 
 * 
 * NOT
 * Parent exception should be at the bottom/end of the block to allow executing the children exceptions first
 */

public class _44_ErrorsAndExceptions {
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