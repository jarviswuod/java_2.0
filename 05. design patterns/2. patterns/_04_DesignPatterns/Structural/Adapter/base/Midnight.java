package _04_DesignPatterns.Structural.Adapter.base;

public class Midnight implements Color {

    @Override
    public void apply(Video video) {
        System.out.println("Applying Midnight-purple to the video");
    }
}
