package _04_DesignPatterns.Structural.Adapter.base;

public class BlackAndWhite implements Color {

    @Override
    public void apply(Video video) {
        System.out.println("Applying black and white to video");
    }
}
