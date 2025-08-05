import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _50_Closing {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = null;
        System.out.print("Input a value > ");

        try {
            InputStreamReader sr = new InputStreamReader(System.in);
            br = new BufferedReader(sr);

            System.out.println(Integer.parseInt(br.readLine()));
        } finally {
            br.close();
        }
    }
}

class _50_Closing_ {

    public static void main(String[] args) throws NumberFormatException, IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Input a value > ");

            System.out.println(Integer.parseInt(br.readLine()));
        }
    }
}