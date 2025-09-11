package _04_DesignPatterns.Behavioral.strategy.good;

public class OverlayBlur implements IOverlay {

    @Override
    public void apply() {
        System.out.println("Applying blur overlay");
    }
}
