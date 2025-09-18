package _04_DesignPatterns.Behavioral.Strategy.good;

public class CompressorMOV implements Compressor {

    @Override
    public void compress() {
        System.out.println("Compressing video using MOV");
    }
}
