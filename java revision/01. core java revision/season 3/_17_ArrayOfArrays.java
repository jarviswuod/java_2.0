public class _17_ArrayOfArrays {

    public static void main(String[] args) {

        int[][] ageBracket = new int[2][3];
        ageBracket[0][0] = 12;
        ageBracket[0][1] = 14;
        ageBracket[0][2] = 16;

        ageBracket[1][0] = 22;
        ageBracket[1][1] = 24;
        ageBracket[1][2] = 26;

        for (int[] is : ageBracket) {
            for (int is2 : is) {
                System.out.print(is2 + ",  ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] ageBracket1 = {
                { 54, 56, 59 },
                { 94, 96, 99 }
        };

        for (int[] is : ageBracket1) {
            for (int is2 : is) {
                System.out.print(is2 + "  ");
            }
            System.out.println();
        }

    }
}
