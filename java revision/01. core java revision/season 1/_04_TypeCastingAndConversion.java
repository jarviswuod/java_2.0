/*
    OFFHEAD NOTES:
     - Casting
        - Explicit -> From a bigger valued variable to a smaller valued variable
        - Implicit/ Conversion

     - Conversion -> From smaller valued variable to a bigger valued variable

 */

public class _04_TypeCastingAndConversion {
    public static void main(String[] args) {
        char letter = 'K';

        String wordAlt = letter + "";
        String word = Character.toString(letter);

        float valueF = 23.45f;
        double valueD = valueF;
        int valueI = (int) valueF;
        int valueID = (int) valueD;

        System.out.println("letter : " + letter);
        System.out.println("wordAlt : " + wordAlt);
        System.out.println("word : " + word);
        System.out.println("valueF : " + valueF);
        System.out.println("valueD : " + valueD);
        System.out.println("valueI : " + valueI);
        System.out.println("valueID : " + valueID);

    }
}
