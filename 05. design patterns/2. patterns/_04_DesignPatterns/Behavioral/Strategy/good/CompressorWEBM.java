package _04_DesignPatterns.Behavioral.Strategy.good;

public class CompressorWEBM implements Compressor {

    @Override
    public void compress() {
        System.out.println("Compressing video using WEBM");
    }
}
