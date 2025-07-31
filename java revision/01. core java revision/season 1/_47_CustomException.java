/*

    OFFHEAD NOTES:
      - extend Exception class
      - contructor
      - super(message)

 */

public class _47_CustomException {

    public static void main(String[] args) {

        try {
            int age = 5;
            int divideBy = 0;
            if (divideBy == 0) {
                throw new JarvisIsException("Custom Message");
            }
            double ans = age / divideBy;

            System.out.println("ans :" + ans);

        } catch (JarvisIsException e) {
            System.out.println("Cannot divide by zero : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Cathing any left out error/ Unhandled Exceptions " + e);
        }
    }
}

class JarvisIsException extends Exception {
    public JarvisIsException(String msg) {
        super(msg);
    }
}