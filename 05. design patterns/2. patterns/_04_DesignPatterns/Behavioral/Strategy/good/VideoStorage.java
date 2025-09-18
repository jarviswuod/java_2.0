package _04_DesignPatterns.Behavioral.Strategy.good;

public class VideoStorage {

    private ICompressor compressor;

    private IOverlay overlay;

    public VideoStorage(ICompressor compressor, IOverlay overlay) {
        this.compressor = compressor;
        this.overlay = overlay;
    }

    public void store(String fileName) {

        compressor.compress();
        overlay.apply();
        // Storing
        System.out.println("Storing video to " + fileName + "." + compressor);
    }

    public ICompressor getCompressor() {
        return compressor;
    }

    public void setCompressor(ICompressor compressor) {
        this.compressor = compressor;
    }

    public IOverlay getOverlay() {
        return overlay;
    }

    public void setOverlay(IOverlay overlay) {
        this.overlay = overlay;
    }

}
