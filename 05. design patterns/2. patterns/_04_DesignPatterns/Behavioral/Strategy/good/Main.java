package _04_DesignPatterns.Behavioral.Strategy.good;

public class Main {
    public static void main(String[] args) {

        VideoStorage videoStorage = new VideoStorage(new CompressorMOV(), new OverlayBlackAndWhite());
        videoStorage.store("/videos/some-movie");

        videoStorage.setCompressor(new CompressorMP4());
        videoStorage.setOverlay(new OverlayBlur());
        videoStorage.store("/videos/some-movie");

    }
}
