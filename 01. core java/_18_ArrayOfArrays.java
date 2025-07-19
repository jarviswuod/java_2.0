public class _18_ArrayOfArrays {

    public static void main(String[] args) {

        // METHOD 2 OF INTITIALIZING ARRAY OF ARRAYS
        // /////////////////////////////////////////////////////////////
        int[][] ageBrackets = new int[3][5];

        ageBrackets[0][0] = 01;
        ageBrackets[0][1] = 02;
        ageBrackets[0][2] = 03;
        ageBrackets[0][3] = 04;
        ageBrackets[0][4] = 05;

        ageBrackets[1][0] = 11;
        ageBrackets[1][1] = 12;
        ageBrackets[1][2] = 13;
        ageBrackets[1][3] = 14;
        ageBrackets[1][4] = 15;

        ageBrackets[2][0] = 21;
        ageBrackets[2][1] = 22;
        ageBrackets[2][2] = 23;
        ageBrackets[2][3] = 24;
        ageBrackets[2][4] = 25;

        for (int[] inBracket : ageBrackets) {
            for (int age : inBracket) {
                System.out.print(age + " ");
            }
            System.out.println();
        }

        // METHOD 1 OF INTITIALIZING ARRAY OF ARRAYS
        // /////////////////////////////////////////////////////////////

        String[][] vehicleBrandAndModel = {
                { "Prado", "Auris", "Axio", "Premio", "Crown" },
                { "C class", "S class", "E class", },
                { "Cx-5", "Cx-3", "Demio" },
        };
        System.out.println();

        for (String[] brand : vehicleBrandAndModel) {
            for (String model : brand) {
                System.out.print(model + "   ");
            }
            System.out.println();
        }

        System.out.println();

        for (int brand = 0; brand < vehicleBrandAndModel.length; brand++) {
            for (int model = 0; model < vehicleBrandAndModel[brand].length; model++) {
                System.out.print(vehicleBrandAndModel[brand][model] + "   ");
            }
            System.out.println();
        }
    }
}