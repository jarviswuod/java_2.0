public class _16_ArraysIntro {

    public static void main(String[] args) {

        int[] ages = new int[3]; // Way 1
        int[] ages2 = { 23, 34, 56 }; // way 2

        ages[0] = 10;
        ages[1] = 20;
        ages[2] = 30;

        for (int i : ages) {
            System.out.print(i + "  ");
        }
        System.out.println();

        for (int i : ages2) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
