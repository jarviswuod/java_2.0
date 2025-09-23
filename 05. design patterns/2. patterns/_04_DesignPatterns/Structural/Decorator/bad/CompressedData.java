package _04_DesignPatterns.Structural.Decorator.bad;

public class CompressedData extends CloudData {

    public CompressedData(String url) {
        super(url);
    }

    @Override
    public void save(String data) {
        String compressed = Compress(data);
        super.save(compressed);
    }

    public String Compress(String data) {
        return data.substring(0, 9);
    }
}
