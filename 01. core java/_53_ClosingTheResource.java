/*

    NOTES:
      - try {...} finally { ... } syntax used to handle resources
      - 'finally' block is always executed irrespective of exception suitable spot for closing the resource
    
      - try () {...}
      - Resources are objects that implement the AutoCloseable interface example BufferedReader
      - Try-with-resources automatically closes resources (BufferedReader), no need for `finally`
      - Hence no need for finally block
      - Ensures cleaner, safer resource management

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _53_ClosingTheResource {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int num = 0;
        BufferedReader br = null;

        try {
            System.out.print("Enter your second number > ");

            InputStreamReader input = new InputStreamReader(System.in);
            br = new BufferedReader(input);
            num = Integer.parseInt(br.readLine());

            System.out.println(num);

        } finally {
            br.close();
        }
    }
}

class _53_ClosingTheResource_ {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int num = 0;
        System.out.print("Enter your first number > ");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            num = Integer.parseInt(br.readLine());
            System.out.println(num);
        }
    }
}