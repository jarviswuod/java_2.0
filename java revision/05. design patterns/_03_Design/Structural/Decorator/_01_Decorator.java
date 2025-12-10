package _03_Design.Structural.Decorator;

/*

    NOTES:
    - Is a structural design pattern that allows dynamic addition of behaviors or responsibilities to objects without changing their code
    - https://claude.ai/chat/686ce628-3b42-4263-bd2e-36e757fde329
    - Key players:
        - Decorators interface
        - Concrete Decorators
        - Component Interface
        - Concrete Component

    - Example:
        - Cloud Data; Storage and Compression

*/

public class _01_Decorator {
    public static void main(String[] args) {

        String url = "google.com/randomrul";
        Data data = new CloudData(url);

        boolean encrypt = true;
        boolean compress = true;

        if (compress)
            data = new CompressData(data);

        if (encrypt)
            data = new EncryptData(data);

        data.save("Hello World, this is my important data!");
    }
}

interface Data {

    void save(String data);
}

class CloudData implements Data {

    private String url;

    public CloudData(String url) {
        this.url = url;
    }

    @Override
    public void save(String data) {
        System.out.println("Doing something with " + data + " provided under the url as " + url);
    }
}

abstract class DataDecorator implements Data {

    protected Data data;

    public DataDecorator(Data data) {
        this.data = data;
    }
}

class CompressData extends DataDecorator {

    public CompressData(Data data) {
        super(data);
    }

    @Override
    public void save(String data) {
        System.out.println("Compressing data...");
        String processed = data.substring(0, Math.min(4, data.length()));
        super.data.save(processed);
    }
}

class EncryptData extends DataDecorator {

    public EncryptData(Data data) {
        super(data);
    }

    @Override
    public void save(String data) {
        System.out.println("Encrypting data...");
        String processed = "!@#$%^&*()(@%$#";
        super.data.save(processed);
    }
}
