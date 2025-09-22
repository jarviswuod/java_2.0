package _04_DesignPatterns.Structural.Adapter.soln;

import _04_DesignPatterns.Structural.Adapter.soln._3rdPartylibrary.Rainbow;

public class RainbowColor_Composition implements Color {

    private Rainbow rainbow;

    public RainbowColor_Composition(Rainbow rainbow) {
        this.rainbow = rainbow;
    }

    @Override
    public void apply(Video video) {
        rainbow.setUp();
        rainbow.update(video);
    }
}
