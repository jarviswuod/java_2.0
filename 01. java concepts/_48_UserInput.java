import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * NOTE:
 * BufferedReader is trying to access InputStreamReader
 * Beuty of BuffereReader is that it can take input from anywhere not just the system keyboard input.
 * It can also take it from file, from the network and anywhere else really
 * 
 * -> BufferedReader is a resource hence open File, DbConnection, Network should be closed
 * 
 */

public class _48_UserInput {
    public static void main(String[] args) throws IOException {

        // METHOD 2
        // /////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////
        System.out.print("Enter a number > ");

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int num1 = Integer.parseInt(br.readLine());

        System.out.println(num1);
        br.close();

        // METHOD 1
        // /////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////
        System.out.print("Enter another number > ");

        Scanner scanner = new Scanner(System.in);
        int num2 = scanner.nextInt();

        System.out.println(num2);
        scanner.close();

    }
}
