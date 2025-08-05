public class _47_CustomException {

    public static void main(String[] args) {
        int divider = 0;
        try {
            int age = 5;

            if (divider == 0) {
                throw new JarvisException("Whatever is say it the answer now");
            }
            int ans = age / divider;
            System.out.println("ans :" + ans);

            int[] ages = new int[2];
            ages[0] = 12;
            ages[1] = 21;
            ages[3] = 321;

        } catch (JarvisException e) {
            System.out.println("Cannot divide by zero dawg " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("I said Out of bound lol");
        } catch (Exception e) {
            System.out.println("Cathing any left out error/ Unhandled Exceptions " + e);
        }
    }
}

class JarvisException extends Exception {
    public JarvisException(String msg) {
        super(msg);
    }
}