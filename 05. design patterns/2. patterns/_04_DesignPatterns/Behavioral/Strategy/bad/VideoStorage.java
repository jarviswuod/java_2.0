package _04_DesignPatterns.Behavioral.Strategy.bad;

public class VideoStorage {

    private Compressors compressors;

    private Overlays overlays;

    public VideoStorage(Compressors compressors) {
        this(compressors, Overlays.None);
    }

    public VideoStorage(Compressors compressors, Overlays overlays) {
        this.compressors = compressors;
        this.overlays = overlays;
    }

    public Compressors getCompressors() {
        return compressors;
    }

    public void setCompressors(Compressors compressors) {
        this.compressors = compressors;
    }

    public Overlays getOverlays() {
        return overlays;
    }

    public void setOverlays(Overlays overlays) {
        this.overlays = overlays;
    }

    public void store(String fileName) {

        // Compression logic
        if (compressors == Compressors.MOV) {
            System.out.println("Compressing using MOV");
        } else if (compressors == Compressors.MP4) {
            System.out.println("Compressing using MP4");
        } else if (compressors == Compressors.WEBM) {
            System.out.println("Compressing using WEBM");
        }

        // Overlay logic
        if (overlays == Overlays.BlackAndWhite) {
            System.out.println("Applying black and white on overlay");
        } else if (overlays == Overlays.Blur) {
            System.out.println("Applying blur overlay");
        } else if (overlays == Overlays.None) {
            System.out.println("Not applying any overlay");
        }

        // Storing
        System.out.println("Storing video to " + fileName + "." + compressors);
    }
}
