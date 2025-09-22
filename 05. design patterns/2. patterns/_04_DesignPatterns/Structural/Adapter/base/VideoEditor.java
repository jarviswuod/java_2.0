package _04_DesignPatterns.Structural.Adapter.base;

public class VideoEditor {

    private Video video;

    public VideoEditor(Video video) {
        this.video = video;
    }

    public void applyColor(Color color) {

        color.apply(video);
    }
}
