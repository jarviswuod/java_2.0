public class _03_TypeCastingAndConversion {
    public static void main(String args[]) {

        // CONVERSION - Smaller Valued variable to a Big valued Variable
        // Also called implicit type casting

        float points = 15.4f;
        double morePoints = points;
        System.out.println("MorePoints: " + morePoints);

        int ageYears = 22;
        double ageMonths = ageYears * 12;
        System.out.println("ageMonths: " + ageMonths);

        // char letter = 'C';
        // String words = letter;

        // CASTING - Bigger value variable to a small Value Variable
        double ageInMonths = 20;
        int ageInYears = (int) ageInMonths / 12;
        System.out.println("ageInYears: " + ageInYears);
    }
}