/*

    NOTES:
    public static void another() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(input);
        scanner.close();
    }


    public static void methodName() throws NumberFormatException, IOException {
        BufferedReader br = null;

        try {

            InputStreamReader st = new InputStreamReader(System.in);
            br = new BufferedReader(st);
            int input = Integer.parseInt(br.readLine());
            System.out.println(input);

        } finally {
            br.close();
        }
    }


    public static void methodName() throws NumberFormatException, IOException {

        BufferedReader br = null;

        try {

            InputStreamReader st = new InputStreamReader(System.in);
            br = new BufferedReader(st);
            int input = Integer.parseInt(br.readLine());
            System.out.println(input);

        } finally {
            br.close();
        }
    }

    public static void methodName() throws NumberFormatException, IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(input);
        }
    }

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _32_UserInput {

    public static void main(String[] args) throws IOException {
        // another();
        methodName();
    }

    public static void another() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(input);
        scanner.close();
    }

    public static void methodName() throws NumberFormatException, IOException {
        BufferedReader br = null;
        try {

            InputStreamReader st = new InputStreamReader(System.in);
            br = new BufferedReader(st);
            int input = Integer.parseInt(br.readLine());
            System.out.println(input);

        } finally {
            br.close();
        }
    }

}
