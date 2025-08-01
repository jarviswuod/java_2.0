/*

    OFFHEAD NOTES:
    - They all boolean expressions (execute to either true or false)
          - greater than -> (>)
          - less than -> (<)
          - greater than or equal to -> (>=)
          - less than or equal to -> (<=)
          - equal to -> (==)
          - not equal to -> (!=)

 */
 
public class _06_RelationalOperations {

    public static void main(String[] args) {
        String name = "Jarvis";
        String sameName = "jarvis";

        System.out.println("5 > 6 : " + (5 > 6));
        System.out.println("10 >= 1 : " + (10 >= 1));
        System.out.println("12 == 23 : " + (12 == 23));
        System.out.println("5 != 6 : " + (5 != 6));
        System.out.println("name == sameName : " + (name == sameName));

    }
}
