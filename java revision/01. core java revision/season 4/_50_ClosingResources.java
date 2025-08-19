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

    try with resources
    ----------------------------
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        int userInput = Integer.parseInt(br.readLine());
        System.out.println(userInput);
    }


    try without resources
    ----------------------------
    BufferedReader br = null;
    try {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int userInput = Integer.parseInt(br.readLine());
        System.out.println(userInput);
    } finally {
        br.close();
    }

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _50_ClosingResources {
    public static void main(String[] args) throws NumberFormatException, IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int userInput = Integer.parseInt(br.readLine());
            System.out.println(userInput);
        }
    }
}

class _50_ClosingResources_ {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            int userInput = Integer.parseInt(br.readLine());
            System.out.println(userInput);
        } finally {
            br.close();
        }

    }
}
