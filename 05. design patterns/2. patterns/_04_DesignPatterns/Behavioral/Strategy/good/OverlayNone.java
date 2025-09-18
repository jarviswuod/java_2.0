package _04_DesignPatterns.Behavioral.Strategy.good;

public class OverlayNone implements Overlay {

    @Override
    public void apply() {
        System.out.println("Applying no overlay");
    }
}
