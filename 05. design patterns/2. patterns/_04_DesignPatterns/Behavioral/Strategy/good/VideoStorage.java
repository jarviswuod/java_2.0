package _04_DesignPatterns.Behavioral.Strategy.good;

public class VideoStorage {

    private Compressor compressor;

    private Overlay overlay;

    public VideoStorage(Compressor compressor, Overlay overlay) {
        this.compressor = compressor;
        this.overlay = overlay;
    }

    public void store(String fileName) {

        compressor.compress();
        overlay.apply();
        // Storing
        System.out.println("Storing video to " + fileName + "." + compressor);
    }

    public Compressor getCompressor() {
        return compressor;
    }

    public void setCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

    public Overlay getOverlay() {
        return overlay;
    }

    public void setOverlay(Overlay overlay) {
        this.overlay = overlay;
    }
}
