/*

    OFFHEAD NOTES:
       - InputStreamReader()
       - BufferedReader()
       - scanner.nextInt();
       - scanner.close();
       - Integer.parseInt(br.readLine());

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _49_UserInput {

    public static void main(String[] args) throws NumberFormatException, IOException {

        System.out.print("When were you born? ");
        Scanner scanner = new Scanner(System.in);
        int birthYear = scanner.nextInt();
        System.out.println("You are " + (2025 - birthYear) + " years old");

        System.out.println();
        System.out.print("When were you born again? ");

        InputStreamReader st = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(st);
        int yearOfBirth = Integer.parseInt(br.readLine());

        br.close();
        scanner.close();

        System.out.println("Okay, just let you know you are " + (2025 - yearOfBirth) + " years old");

    }
}
