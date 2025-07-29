/*
    OFFHEAD NOTES:
     - jagged Array is a special array of arrays with different lengths
     - Example
         - int[][] ages = new int[3][];

 */

public class _18_JaggedArray {

    public static void main(String[] args) {

        int[][] ageGroup = new int[4][];

        ageGroup[0] = new int[8];
        ageGroup[1] = new int[5];
        ageGroup[2] = new int[2];
        ageGroup[3] = new int[6];

        for (int i = 0; i < ageGroup.length; i++) {
            for (int j = 0; j < ageGroup[i].length; j++) {
                ageGroup[i][j] = (int) (Math.random() * 10);
            }
        }

        System.out.println("ageGroup: ");
        for (int[] is : ageGroup) {
            for (int age : is) {
                System.out.print(age + "  ");
            }
            System.out.println();
        }
    }
}
