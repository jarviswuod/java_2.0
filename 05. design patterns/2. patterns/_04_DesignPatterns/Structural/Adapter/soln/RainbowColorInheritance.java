package _04_DesignPatterns.Structural.Adapter.soln;

import _04_DesignPatterns.Structural.Adapter.soln._3rdPartylibrary.Rainbow;

public class RainbowColorInheritance extends Rainbow implements Color {

    @Override
    public void apply(Video video) {
        setUp();
        update(video);
    }
}
