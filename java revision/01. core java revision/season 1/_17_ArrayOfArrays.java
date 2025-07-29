/*

    OFFHEAD NOTES:
     - Creating an array that stores different arrays inside of it.
     - Either same of different lenghts
     - 2 ways of creating array of arrays
        - int[][] ages = new int[3][5];
        - int[][] ages = {{...}, {...}, {...}};

 */

public class _17_ArrayOfArrays {

    public static void main(String[] args) {

        int[][] ageGroupSample1 = {
                { 14, 16, 19, 17 },
                { 21, 22, 28, 29 },
                { 31, 33, 38, 39 },
                { 41, 44, 48, 49 }
        };

        int[][] ageGroupSample2 = new int[3][3];
        ageGroupSample2[0][0] = 14;
        ageGroupSample2[0][1] = 16;
        ageGroupSample2[0][2] = 19;

        ageGroupSample2[1][0] = 21;
        ageGroupSample2[1][1] = 22;
        ageGroupSample2[1][2] = 28;

        ageGroupSample2[2][0] = 31;
        ageGroupSample2[2][1] = 33;
        ageGroupSample2[2][2] = 38;

        System.out.println("ageGroupSample1: ");
        for (int[] is : ageGroupSample1) {
            for (int age : is) {
                System.out.print(age + "  ");
            }
            System.out.println();
        }

        System.out.println("ageGroupSample2: ");
        for (int[] is : ageGroupSample2) {
            for (int age : is) {
                System.out.print(age + "  ");
            }
            System.out.println();
        }
    }
}
