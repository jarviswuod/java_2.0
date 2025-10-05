/*

    NOTES:
    - char -> String:
        - char + ""
        - Character.toString(charName);
        - String.

    - Casting:
        - From a larger value variable to a smaller value variable
    
    - Convertion: implicit casting
        - From a smaller value variable to a larger value variable

 */

public class _04_TypeCastingAndConversion {
    public static void main(String[] args) {

        char letter = 'l';
        String word = Character.toString(letter);
        System.out.println(word);
    }
}
