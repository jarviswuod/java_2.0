public class _17_ArraysOfArrays {

    public static void main(String[] args) {
        int[][] ageBrackets = new int[2][3];

        ageBrackets[0][0] = 12;
        ageBrackets[0][1] = 18;
        ageBrackets[0][2] = 33;

        ageBrackets[1][0] = 22;
        ageBrackets[1][1] = 28;
        ageBrackets[1][2] = 12;

        for (int[] is : ageBrackets) {
            for (int age : is) {
                System.out.print(age + "  ");
            }
            System.out.println();
        }
    }
}
