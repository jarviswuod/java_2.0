public class _18_JaggedArray {

    public static void main(String[] args) {

        int[][] ageBracket = new int[3][];
        ageBracket[0] = new int[4];
        ageBracket[1] = new int[5];
        ageBracket[2] = new int[7];

        for (int i = 0; i < ageBracket.length; i++) {
            for (int j = 0; j < ageBracket[i].length; j++) {
                ageBracket[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int[] is : ageBracket) {
            for (int is2 : is) {
                System.out.print(is2 + ",  ");
            }
            System.out.println();
        }
    }
}