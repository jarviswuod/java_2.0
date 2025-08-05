public class _40_FucntionalInterface {

    public static void main(String[] args) {
        RandomInterface randomInterface = new RandomInterface() {

            @Override
            public void showRandom() {
                System.out.println("showRandom : ");
            }
        };

        randomInterface.showRandom();
    }
}

@FunctionalInterface
interface RandomInterface {
    void showRandom();
}
