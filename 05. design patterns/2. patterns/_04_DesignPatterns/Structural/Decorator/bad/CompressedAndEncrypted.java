package _04_DesignPatterns.Structural.Decorator.bad;

public class CompressedAndEncrypted extends CloudData {

    public CompressedAndEncrypted(String url) {
        super(url);
    }

    @Override
    public void save(String data) {
        String compressed = new CompressedData(url).Compress(data);
        String compressedAndEncrypted = new EncryptedData(url).Encrypt(compressed);
        super.save(compressedAndEncrypted);
    }

    public String CompressedAndEncrypt(String data) {
        return data.substring(0, 9);
    }
}
