package _04_DesignPatterns.Structural.Decorator.good;

public class CompressionDecorator extends DataDecorator {

    public CompressionDecorator(Data data) {
        super(data);
    }

    @Override
    public void save(String data_) {

        String compressed = compress(data_);
        super.data.save(compressed);

        System.out.println("Data compressed successfully!!!");
    }

    public String compress(String data_) {
        return data_.substring(0, 9);
    }
}