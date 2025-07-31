/*

 OFFHEAD NOTES:
 try{} finally{} coz finally is executed weather or not there is an exception

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _50_ClosingTheResource {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = null;
        int userinput;

        try {
            System.out.print("Age : ");
            InputStreamReader sr = new InputStreamReader(System.in);
            br = new BufferedReader(sr);
            userinput = Integer.parseInt(br.readLine());

        } finally {
            br.close();
        }
        System.out.println("Age Anywhere else really: " + userinput);

    }
}

class _50_ClosingTheResource_ {

    public static void main(String[] args) throws NumberFormatException, IOException {

        int userinput;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Age : ");

            userinput = Integer.parseInt(br.readLine());
        }

        System.out.println("Age Anywhere else AGAIN: " + userinput);

    }
}
