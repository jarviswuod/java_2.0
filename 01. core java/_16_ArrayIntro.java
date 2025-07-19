public class _16_ArrayIntro {
    public static void main(String[] args) {

        // METHOD 2 OF INTITIALIZING ARRAYS
        // /////////////////////////////////////////////////////////////
        String[] vehicle = new String[5];

        vehicle[0] = "toyota";
        vehicle[1] = "Benz";
        vehicle[2] = "Ford";
        vehicle[3] = "Nissan";
        vehicle[4] = "Mazda";
        // vehicle[5] = "Subaru";

        for (String brand : vehicle) {
            System.out.print(brand + "  ");
        }
        System.out.println();

        // METHOD 1 OF INTITIALIZING ARRAYS
        // /////////////////////////////////////////////////////////////

        String[] names = { "Jarvis", "Dommy", "Annyse", "Davis" };
        int[] ages = { 24, 23, 12, 18 };

        for (String name : names) {
            System.out.print(name + "   ");
        }
        System.out.println();

        names[2] = "Dancan";
        for (String name : names) {
            System.out.print(name + "   ");
        }
        System.out.println();

        for (int i : ages) {
            System.out.print(i + "   ");
        }
        System.out.println();

    }
}
