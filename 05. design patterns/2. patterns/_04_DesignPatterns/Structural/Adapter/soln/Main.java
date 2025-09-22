package _04_DesignPatterns.Structural.Adapter.soln;

import _04_DesignPatterns.Structural.Adapter.soln._3rdPartylibrary.Rainbow;

public class Main {
    public static void main(String[] args) {

        VideoEditor videoEditor = new VideoEditor(new Video());

        videoEditor.applyColor(new BlackAndWhite()); // Applying black and white to video
        videoEditor.applyColor(new RainbowColor_Composition(new Rainbow())); // Applying rainbow filter to video
    }
}
