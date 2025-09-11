package _04_DesignPatterns.Behavioral.strategy.good;

public class OverlayBlackAndWhite implements IOverlay {

    @Override
    public void apply() {
        System.out.println("Applying black and white overlay");
    }
}
