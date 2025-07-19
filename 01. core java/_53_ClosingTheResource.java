/*
    NOTE:
      - finally block (keyword) in try catch is always executed irrespective of exception
      - Suitable spot for closing the resource
    
      - Try-with-resources automatically closes resources (BufferedReader)
      - Hence no need for finally block

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _53_ClosingTheResource {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int num = 0;
        BufferedReader br = null;

        try {
            System.out.print("Enter your second number > ");

            InputStreamReader input = new InputStreamReader(System.in);
            br = new BufferedReader(input);
            num = Integer.parseInt(br.readLine());

            System.out.println(num);

        } finally {
            br.close();
        }
    }
}

class _53_ClosingTheResource_ {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int num = 0;
        System.out.print("Enter your first number > ");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            num = Integer.parseInt(br.readLine());
            System.out.println(num);
        }
    }
}