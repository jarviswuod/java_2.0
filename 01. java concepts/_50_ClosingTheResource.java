import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * finally block (keyword) in try catch is always executed irrespective of exception.
 * Suitable spot for closing the resource
 * 
 */

public class _50_ClosingTheResource {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int num1 = 0;
        BufferedReader br = null;

        try {
            System.out.print("Enter your second number > ");

            InputStreamReader input = new InputStreamReader(System.in);
            br = new BufferedReader(input);
            num1 = Integer.parseInt(br.readLine());

            System.out.println(num1);

        } finally {
            br.close();
        }

    }
}

/*
 * Try-with-resources automatically closes the BufferedReader
 * No need for finally block - resources are automatically closed
 * 
 */

class _50_ClosingTheResource_ {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int num2 = 0;
        System.out.print("Enter your first number > ");

        try (BufferedReader br_ = new BufferedReader(new InputStreamReader(System.in))) {
            num2 = Integer.parseInt(br_.readLine());
            System.out.println(num2);
        }
    }
}