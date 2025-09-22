package _04_DesignPatterns.Structural.Adapter.base;

public class Main {
    public static void main(String[] args) {

        VideoEditor videoEditor = new VideoEditor(new Video());
        videoEditor.applyColor(new BlackAndWhite()); // Applying black and white to video
    }
}
