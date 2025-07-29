/*

    OFFHEAD NOTES:
        do {
             // execute the code block
        } while(condition);
        
    Executes the block atleast once before stopping
 */

public class _13_DoWhileLoop {

    public static void main(String[] args) {
        int iterate = 11;

        do {
            System.out.println("Iterate : " + iterate);
            iterate++;
        } while (iterate <= 10);
    }
}
