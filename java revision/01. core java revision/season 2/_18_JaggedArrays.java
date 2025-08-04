public class _18_JaggedArrays {

    public static void main(String[] args) {
        int[][] ageBrackets = new int[5][];

        ageBrackets[0] = new int[4];
        ageBrackets[1] = new int[6];
        ageBrackets[2] = new int[2];
        ageBrackets[3] = new int[5];
        ageBrackets[4] = new int[9];
        // ageBrackets[0]=new int[4];

        for (int i = 0; i < ageBrackets.length; i++) {
            for (int j = 0; j < ageBrackets[i].length; j++) {
                ageBrackets[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int[] is : ageBrackets) {
            for (int age : is) {
                System.out.print(age + "  ");
            }
            System.out.println();
        }
    }
}
