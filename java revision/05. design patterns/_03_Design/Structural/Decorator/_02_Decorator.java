package _03_Design.Structural.Decorator;

/*

    NOTES:
    - Is a structural design pattern that allows addition of behavior or algorithm at runtime
    - Key players:
        - Decorator interface
        - Concrete Decorator
        - Component interface
        - Concrete Component

    - Example:
        - Cloud Storage; EncryptionDecorator & CompressionDecorator

*/

public class _02_Decorator {
    public static void main(String[] args) {

        String url = "file/path/home";
        _02_Data data = new _02_CloudData(url);

        boolean encrypt = true;
        boolean compress = true;

        if (compress)
            data = new _02_CompressDecorator(data);

        if (encrypt)
            data = new _02_EncryptDecorator(data);

        data.save("Im here to not fight but talk");
    }
}

interface _02_Data {

    void save(String data);
}

class _02_CloudData implements _02_Data {

    private String url;

    public _02_CloudData(String url) {
        this.url = url;
    }

    @Override
    public void save(String data) {
        System.out.println("Data " + data + " url " + url);
    }
}

abstract class _02_DataDecorator implements _02_Data {

    protected _02_Data data;

    public _02_DataDecorator(_02_Data data) {
        this.data = data;
    }
}

class _02_CompressDecorator extends _02_DataDecorator {

    public _02_CompressDecorator(_02_Data data) {
        super(data);
    }

    @Override
    public void save(String data) {
        System.out.println("Compressing data");
        String compressed = data.substring(0, Math.min(9, data.length()));
        super.data.save(compressed);
    }
}

class _02_EncryptDecorator extends _02_DataDecorator {

    public _02_EncryptDecorator(_02_Data data) {
        super(data);
    }

    @Override
    public void save(String data) {
        System.out.println("Encrypting data");
        String encrypted = "*_)@%*!@#$%^*+=#)";
        super.data.save(encrypted);
    }
}
