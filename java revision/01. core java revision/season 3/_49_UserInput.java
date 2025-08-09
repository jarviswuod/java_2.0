/*
    Scanner scanner = new Scanner(System.in);
    int userInput = scanner.nextLine(); // nextInt();
    scanner.close();

    InputStreamReader sr =  new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(sr);
    int userValue = Integer.parseInt(br.readLine());
    System.out.println(userValue)
    br.close();


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _49_UserInput {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine(); // nextInt();
        System.out.println(userInput);

        scanner.close();

        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        int userValue = Integer.parseInt(br.readLine());
        System.out.println(userValue);
        br.close();
    }
}