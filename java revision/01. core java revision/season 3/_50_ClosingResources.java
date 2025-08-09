/*
    BufferedReader br = null;
    int userInput;

    try {
        InputStreamReader sr = new InputStreamReader(System.in);
        br = new BufferedReader(sr);
        userInput = Integer.parseInt(br.readLine());
    } finally {
        br.close(); 
    }

    System.out.println(userInput);



    ----------------------------- TRY WITH CLOSE RESOURCES -----------------------------
    
    int userInput;
    try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
        userInput = Integer.parseInt(br.readLine());
    }
    System.out.println(userInput);

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _50_ClosingResources {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = null;
        int userInput;

        try {
            InputStreamReader sr = new InputStreamReader(System.in);
            br = new BufferedReader(sr);
            userInput = Integer.parseInt(br.readLine());
        } finally {
            br.close();
        }

        System.out.println(userInput);

        // ----------------------------- TRY WITH CLOSE RESOURCES

        int userInput_;

        try (BufferedReader br_ = new BufferedReader(new InputStreamReader(System.in))) {
            userInput_ = Integer.parseInt(br_.readLine());
        }
        System.out.println(userInput_);
    }
}
