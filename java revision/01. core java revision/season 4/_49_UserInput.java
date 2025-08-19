/*

    NOTES:
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    int userInput = Integer.parseInt(br.readLine());
    System.out.println(userInput);
    br.close();


    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine(); // nextInt()
    System.out.println(input);
    scanner.close();

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _49_UserInput {
    public static void main(String[] args) throws NumberFormatException, IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int userInput = Integer.parseInt(br.readLine());
        System.out.println(userInput);
        br.close();

    }
}

class Inner_49_UserInput_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // nextInt()
        System.out.println(input);
        scanner.close();
    }

}