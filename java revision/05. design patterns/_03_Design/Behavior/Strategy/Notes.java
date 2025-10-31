package _03_Design.Behavior.Strategy;

/*

    NOTES:
    - Stratergy Design pattern:
        - Is a behavioral pattern that allows an object to modify it;s behaviour whenever it's internal state changes

    - 3 key players
        - Context:
            -

        - Strategy:
            -

        - ConcreteStrategy:
            -

 */

public class Notes {
    public static void main(String[] args) {
        VideoStorage videoStorage = new VideoStorage(new Blur(), new CompMP4());
        videoStorage.store("random/location/");
        System.out.println();

        videoStorage.setCompressor(new ZipForm());
        videoStorage.setOverlay(new BlackAndWhite());
        videoStorage.store("random2/location2/");

    }
}

interface Overlay {
    void apply();
}

interface Compressor {
    void compress();
}

class VideoStorage {
    private Overlay overlay;
    private Compressor compressor;

    public VideoStorage(Overlay overlay, Compressor compressor) {
        this.overlay = overlay;
        this.compressor = compressor;
    }

    public void store(String filePath) {
        overlay.apply();
        compressor.compress();
        System.out.println("Video settings of " + filePath + "changed successfully");
    }

    public void setOverlay(Overlay overlay) {
        this.overlay = overlay;
    }

    public void setCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

}

class Blur implements Overlay {

    @Override
    public void apply() {
        System.out.println("Applying blur to video");
    }
}

class Greyscale implements Overlay {

    @Override
    public void apply() {
        System.out.println("Applying grey scale to video");
    }
}

class BlackAndWhite implements Overlay {

    @Override
    public void apply() {
        System.out.println("Applying black and white to video");
    }
}

class CompMP4 implements Compressor {

    @Override
    public void compress() {
        System.out.println("Compressing video to mp4");
    }
}

class ZipForm implements Compressor {

    @Override
    public void compress() {
        System.out.println("Compressing video to ZipForm");
    }
}

class Unknown implements Compressor {

    @Override
    public void compress() {
        System.out.println("Compressing video to Unknown");
    }
}