package _04_DesignPatterns.Structural.Adapter.soln._3rdPartylibrary;

import _04_DesignPatterns.Structural.Adapter.soln.Video;

public class Rainbow {

    public void setUp() {
        System.out.println("Setting up rainbow filter");
    }

    public void update(Video video) {
        System.out.println("Applying rainbow filter to video");
    }
}
