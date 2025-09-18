package _04_DesignPatterns.Behavioral.Strategy.good;

public class CompressorMP4 implements Compressor {

    @Override
    public void compress() {
        System.out.println("Compressing video using MP4");
    }
}
