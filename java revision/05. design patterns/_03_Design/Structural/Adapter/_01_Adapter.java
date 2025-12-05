package _03_Design.Structural.Adapter;

/*

    NOTES:
    - Is a structural design pattern that enables communication incompatible object interfaces via a bridge
    - Key players:
        - Target
        - Adapter
        - Adaptee

    - Example:
        - VideoEditor with Color

*/

public class _01_Adapter {
    public static void main(String[] args) {

        VideoEditor_ videoEditor = new VideoEditor_(new Video_());
        videoEditor.applyColor(new BlackAndWhite_());

        videoEditor.applyColor(new Maroon_(new MaroonThird_()));

        System.out.println();
        videoEditor.applyColor(new MaroonInherit_());

    }
}

class Video_ {
}

interface Color_ {

    void apply(Video_ video);
}

class BlackAndWhite_ implements Color_ {

    @Override
    public void apply(Video_ video) {
        System.out.println("Applying Black and white to video");
    }
}

class MidnightPurprle_ implements Color_ {

    @Override
    public void apply(Video_ video) {
        System.out.println("Applying Midnight Purprle to video");
    }
}

class VideoEditor_ {
    private Video_ video;

    public VideoEditor_(Video_ video) {
        this.video = video;
    }

    public void applyColor(Color_ color) {
        color.apply(video);
    }
}

class MaroonThird_ {
    public void setup() {
        System.out.println("Setting up Third party package");
    }

    public void apply(Video_ video) {
        System.out.println("Applying Maroon to video");
    }
}

class Maroon_ implements Color_ {
    private MaroonThird_ maroonThird;

    public Maroon_(MaroonThird_ maroonThird) {
        this.maroonThird = maroonThird;
    }

    @Override
    public void apply(Video_ video) {
        maroonThird.setup();
        maroonThird.apply(video);
    }
}

class MaroonInherit_ extends MaroonThird_ implements Color_ {

    @Override
    public void apply(Video_ video) {
        setup();
        apply(video);
    }
}