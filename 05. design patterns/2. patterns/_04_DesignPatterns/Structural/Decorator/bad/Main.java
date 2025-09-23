package _04_DesignPatterns.Structural.Decorator.bad;

public class Main {
    public static void main(String[] args) {

        String url = "https://google.cloud.com";
        String data = "This is some data. Hello world. Facade :)";
        boolean compress = true;
        boolean encrypt = true;

        CloudData cloudData = new CloudData(url);

        if (encrypt && compress) {
            cloudData = new CompressedAndEncrypted(url);
        } else if (compress) {
            cloudData = new CompressedData(url);
        } else if (encrypt) {
            cloudData = new EncryptedData(url);
        }

        cloudData.save(data);
    }
}
