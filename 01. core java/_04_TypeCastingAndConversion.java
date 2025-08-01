/*

    NOTES:
    - Casting
        - Explicit -> From a bigger valued variable to a smaller valued variable
        - Implicit/ Conversion

    - Conversion -> From smaller valued variable to a bigger valued variable

 */

public class _04_TypeCastingAndConversion {
    public static void main(String args[]) {

        float points = 15.4f;
        double morePoints = points;
        System.out.println("MorePoints: " + morePoints);

        int ageYears = 22;
        double ageMonths = ageYears * 12;
        System.out.println("ageMonths: " + ageMonths);

        char letter = 'C';
        String words1 = String.valueOf(letter);
        String words2 = Character.toString(letter);
        String words3 = "" + letter;
        System.out.println("method1: " + words1 + " method2: " + words2 + " method3: " + words3);

        // CASTING - Bigger value variable to a small Value Variable
        double ageInMonths = 20;
        int ageInYears = (int) ageInMonths / 12;
        System.out.println("ageInYears: " + ageInYears);
    }
}