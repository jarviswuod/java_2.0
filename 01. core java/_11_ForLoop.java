/*

    NOTES:
        for(;;){
            // execute the block infinity times
        }

 */

public class _11_ForLoop {

    public static void main(String[] args) {

        // Incremental for loop
        for (int i = 1; i <= 10; i++) {
            System.out.println("Count i : " + i);
        }

        System.out.println();

        // Decremental for loop
        for (int i = 10; i > 0; i--) {
            System.out.println("Count i : " + i);
        }
    }
}