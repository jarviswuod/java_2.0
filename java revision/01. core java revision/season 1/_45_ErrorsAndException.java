/*
 
OFFHEAD NOTES:
 try {} catch(Execption e){}
 Exception e comes -> last as its the parent of all excpetion

 Error types:
 runtime - compile time
 syntax
 bugs


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
