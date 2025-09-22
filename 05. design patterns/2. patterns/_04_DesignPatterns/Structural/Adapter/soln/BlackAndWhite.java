package _04_DesignPatterns.Structural.Adapter.soln;

public class BlackAndWhite implements Color {

    @Override
    public void apply(Video video) {
        System.out.println("Applying black and white to video");
    }
}
