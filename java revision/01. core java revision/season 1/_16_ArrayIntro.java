/*

    OFFHEAD NOTES:
     - 2 ways of initializing an array
         - int[] ageSample1 = { ... };
         - int[] ageSample2 = new int[4];

 */

public class _16_ArrayIntro {

    public static void main(String[] args) {

        int[] ageSample1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int[] ageSample2 = new int[4];
        ageSample2[0] = 21;
        ageSample2[1] = 21;
        ageSample2[2] = 21;
        ageSample2[3] = 21;

        System.out.println("ageSample1 : " + ageSample1);
        System.out.println("ageSample2 : " + ageSample2);
        System.out.println();

        System.out.print("ageSample1 : ");
        for (int i : ageSample1) {
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.print("ageSample2 : ");
        for (int i : ageSample2) {
            System.out.print(i + ", ");
        }
        System.out.println();

    }
}
