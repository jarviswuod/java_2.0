package _04_DesignPatterns.Structural.Decorator.good;

public class Main {

    public static void main(String[] args) {
        String url = "https://google.cloud.com";
        String data = "This is some data. Hello world. Facade :)";
        boolean compress = false;
        boolean encrypt = false;

        Data cloudData = new CloudData(url);

        if (compress) {
            cloudData = new CompressionDecorator(cloudData);
        }
        if (encrypt) {
            cloudData = new EncryptionDecorator(cloudData);
        }

        cloudData.save(data);
    }
}
