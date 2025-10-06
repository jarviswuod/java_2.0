/*

    NOTES:
    - 2 ways of doing it;
        - Scanner
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            System.out.println("input : " + input);
            scanner.close();



        - BufferredReader
            InputStreamReader st =  new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(st);
            String name = br.readLine();

            System.out.println("name : " + name);
            br.close();

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _49_UserInput {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("input : " + input);
        scanner.close();
    }
}

class _49_UserInput_ {
    public static void main(String[] args) throws IOException {

        InputStreamReader st = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(st);
        String name = br.readLine();

        System.out.println("name : " + name);
        br.close();
    }
}