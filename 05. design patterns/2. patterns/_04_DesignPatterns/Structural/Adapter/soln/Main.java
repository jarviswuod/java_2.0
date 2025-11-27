package _04_DesignPatterns.Structural.Adapter.soln;

import _04_DesignPatterns.Structural.Adapter.soln._3rdPartylibrary.Rainbow;

public class Main {
    public static void main(String[] args) {

        VideoEditor videoEditor = new VideoEditor(new Video());

        videoEditor.applyColor(new BlackAndWhite()); // Applying black and white to video
        System.out.println();

        videoEditor.applyColor(new RainbowColorInheritance()); // Applying rainbow filter to video
        System.out.println();

        videoEditor.applyColor(new Midnight()); // Applying Midnight-purple to the video
        System.out.println();

        videoEditor.applyColor(new RainbowColorComposition(new Rainbow())); // Applying rainbow filter to video
    }
}
