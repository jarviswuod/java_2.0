/*
 * Execute atleast once before stoping otherwise
 */
public class _12_DoWhileLoop {

    public static void main(String[] args) {

        int count = 10;

        do {
            System.out.println("Count : " + count);
            count++;
        } while (count <= 10);
    }
}