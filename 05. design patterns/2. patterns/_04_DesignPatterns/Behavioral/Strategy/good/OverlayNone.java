package _04_DesignPatterns.Behavioral.Strategy.good;

public class OverlayNone implements IOverlay {

    @Override
    public void apply() {
        System.out.println("Applying no overlay");
    }
}
