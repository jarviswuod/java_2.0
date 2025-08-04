/*
 
    OFFHEAD NOTES:
     - casting
        - explicit -> Converting some small value varaible to a big value variable
        - implicit -> Converting some big value variable to some small value variable

     - conversion also known as implicit casting

 */

public class _04_TypeCastingAndConvertion {

    public static void main(String[] args) {

        char letter = 'L';
        String firstWord = letter + "";
        String secondWord = Character.toString(letter);

        double ageDouble = 21.14;
        float ageFloat = 14.6f;

        int ageInteger = (int) ageDouble; // casting
        int ageInt = (int) ageFloat;

        System.out.println("letter : " + letter);
        System.out.println("firstWord : " + firstWord);
        System.out.println("secondWord : " + secondWord);
        System.out.println("ageDouble : " + ageDouble);
        System.out.println("ageFloat : " + ageFloat);
        System.out.println("ageInteger : " + ageInteger);
        System.out.println("ageInt : " + ageInt);
    }
}
