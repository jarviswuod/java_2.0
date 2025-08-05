import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _49_UserInput {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a value > ");

        System.out.println(scanner.nextInt());
        scanner.close();

        InputStreamReader sr = new InputStreamReader(System.in);
        System.out.print("Input a value > ");

        BufferedReader br = new BufferedReader(sr);
        System.out.println(Integer.parseInt(br.readLine()));

        br.close();
    }
}
