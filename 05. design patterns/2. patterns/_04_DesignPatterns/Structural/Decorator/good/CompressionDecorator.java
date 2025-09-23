package _04_DesignPatterns.Structural.Decorator.good;

public class CompressionDecorator extends DataDecorator {

    public CompressionDecorator(Data data) {
        super(data);
    }

    @Override
    public void save(String data) {

        System.out.println("Compressing data");
        String compressed = Compress(data);
        super.data.save(compressed);
    }

    public String Compress(String data) {
        return data.substring(0, 9);
    }
}
