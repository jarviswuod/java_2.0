/*

    NOTES:
    - 2 Creating a jagged array
        - int[][] numbers = new int[4][];
          numbers[0] = new int [2]; 
          numbers[1] = new int [7]; 
          numbers[2] = new int [3]; 
          numbers[3] = new int [5]; 

          numbers[0][1] = 12;


 */

public class _18_JaggedArrays {
    public static void main(String[] args) {

        int[][] numbers = new int[4][];
        numbers[0] = new int[2];
        numbers[1] = new int[7];
        numbers[2] = new int[3];
        numbers[3] = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {

                numbers[i][j] = (int) (Math.random() * 10);
            }
        }

        numbers[0][1] = 12;

        for (int[] is : numbers) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }
    }
}
