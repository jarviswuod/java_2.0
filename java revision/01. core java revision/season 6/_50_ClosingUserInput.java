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

public class _50_ClosingUserInput {
    public static void main(String[] args) {

        Scanner scanner = null;

        try {

            scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            System.out.println("input : " + input);

        } catch (Exception e) {
            scanner.close();
        }
    }
}

class _50_ClosingUserInput_ {
    public static void main(String[] args) throws IOException {

        BufferedReader br = null;

        try {
            InputStreamReader st = new InputStreamReader(System.in);
            br = new BufferedReader(st);
            String name = br.readLine();
            System.out.println("name : " + name);

        } catch (Exception e) {
            br.close();
        }
    }
}

class _50_ClosingUserInput_Scanner_Resource {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            scanner.nextLine();
            String input = scanner.nextLine();
            System.out.println("input : " + input);
        }
    }
}

class _50_ClosingUserInput_Resource {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String name = br.readLine();
            System.out.println("name : " + name);

        }
    }
}
