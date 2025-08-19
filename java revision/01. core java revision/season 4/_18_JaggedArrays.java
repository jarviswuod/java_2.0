/*

    NOTES:
    int[][] age = new int[4][];
    int[][] age1 = {
        {21, 54, 76},
        {54, 76},
        {21, 54, 76, 21, 54, 76},
        {12},
    };

    age[0] = new int[9];
    age[1] = new int[6];
    age[3] = new int[3];
    age[2] = new int[5];

    looping:
        for(int i = 0; i< age.length; i++) {
            for(int j = 0; j< age[i].length; j++) {
                age[i][j] = (int)(Math.random()* 10)
            }
        }
        for(int[] group : age) {
            for(int ageValue : group) {
                block;
            }
        }

 */

public class _18_JaggedArrays {
    public static void main(String[] args) {
        int[][] age = new int[4][];

        age[0] = new int[9];
        age[1] = new int[6];
        age[3] = new int[3];
        age[2] = new int[5];

        for (int i = 0; i < age.length; i++) {
            for (int j = 0; j < age[i].length; j++) {
                age[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int[] group : age) {
            for (int ageValue : group) {
                System.out.print(ageValue + ", ");
            }
            System.out.println();
        }
    }
}
