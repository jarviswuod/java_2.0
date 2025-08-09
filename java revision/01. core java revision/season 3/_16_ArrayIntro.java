public class _16_ArrayIntro {

    public static void main(String[] args) {

        int[] age1 = new int[4];
        age1[0] = 34;
        age1[1] = 24;
        age1[3] = 44;
        age1[2] = 33;

        for (int i : age1) {
            System.out.println(i);
        }

        System.out.println();

        int[] age2 = { 2323, 3223, 4545, 7676 };
        for (int i : age2) {
            System.out.println(i);
        }
    }
}
