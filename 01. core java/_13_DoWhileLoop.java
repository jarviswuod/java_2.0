/*

    NOTES:
    - Executes the block atleast once before stopping
        do {
             // execute the code block
        } while(condition);

 */

public class _13_DoWhileLoop {

    public static void main(String[] args) {

        int count = 10;

        do {
            System.out.println("Count : " + count);
            count++;
        } while (count <= 10);
    }
}