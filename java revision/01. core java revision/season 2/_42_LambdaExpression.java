public class _42_LambdaExpression {

    public static void main(String[] args) {

        RandomInterface randomInterface = () -> {
            System.out.println("showRandom : ");
        };

        randomInterface.showRandom();
    }
}

@FunctionalInterface
interface RandomInterface {
    void showRandom();
}