/*

    NOTES:
       - jagged Array is a special array of arrays with different lengths
       - Example
           - int[][] ages = new int[3][];

 */

public class _18_JaggedArray {

    public static void main(String[] args) {

        int[][] nums = new int[3][];

        nums[0] = new int[3];
        nums[1] = new int[2];
        nums[2] = new int[4];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int[] array : nums) {
            for (int num : array) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }
    }
}
