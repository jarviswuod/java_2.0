package _04_DesignPatterns.Behavioral.Strategy.good;

public class OverlayBlur implements Overlay {

    @Override
    public void apply() {
        System.out.println("Applying blur overlay");
    }
}
