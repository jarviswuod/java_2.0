package _03_Design.Structural.Adapter;

/*

    NOTES:
    - Is a structural design pattern that connections object that have different interfaces via bridge
    - Key players:
        - Target
        - Adapter
        - Adaptee

*/

public class _02_Adapter {
    public static void main(String[] args) {

        _02_Video video = new _02_Video();
        _02_VideoEditor videoEditor = new _02_VideoEditor(video);
        videoEditor.applyColor(new _02_BlackAndWhite());

        videoEditor.applyColor(new _02_Gray());
        videoEditor.applyColor(new _02_Rainbow(new _02_RainbowColor()));

    }
}

class _02_VideoEditor {

    private _02_Video video;

    public _02_VideoEditor(_02_Video video) {
        this.video = video;
    }

    public void applyColor(_02_Color color) {
        color.apply(video);
    }
}

class _02_Video {
}

interface _02_Color {

    void apply(_02_Video video);
}

class _02_BlackAndWhite implements _02_Color {

    @Override
    public void apply(_02_Video video) {
        System.out.println("Applying black and white color to " + video.getClass().getName());
    }
}

class _02_Gray implements _02_Color {

    @Override
    public void apply(_02_Video video) {
        System.out.println("Applying a Gray color to " + video.getClass().getName());
    }
}

class _02_RainbowColor {

    public void setUp() {
        System.out.println("Basic setup from 3rd party package");
    }

    public void applied() {
        System.out.println("Applied Rainbow to video");
    }
}

class _02_Rainbow implements _02_Color {

    private _02_RainbowColor rainbowColor;

    public _02_Rainbow(_02_RainbowColor rainbowColor) {
        this.rainbowColor = rainbowColor;
    }

    @Override
    public void apply(_02_Video video) {
        rainbowColor.setUp();
        rainbowColor.applied();
    }
}
