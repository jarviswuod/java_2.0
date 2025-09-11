package _04_DesignPatterns.Behavioral.strategy.good;

public class CompressorMOV implements ICompressor {

    @Override
    public void compress() {
        System.out.println("Compressing video using MOV");
    }
}
