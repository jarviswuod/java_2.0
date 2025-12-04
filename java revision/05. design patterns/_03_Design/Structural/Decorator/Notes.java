package _03_Design.Structural.Decorator;

/*

    NOTES:
    - Decorator design pattern:
        - Is a structural design pattern that allows dynamic addition of behaviors or responsibilities without affecting their code

    - https://claude.ai/chat/686ce628-3b42-4263-bd2e-36e757fde329

    - key players:
        - Decorator interface
        - Concrete Decorator
        - Component interface
        - Concrete Component


    FIRST DRAFT:::

            public class Notes {
                public static void main(String[] args) {

                    String url = "https://google.cloud.com";
                    String data = "This is some data. Hello world. Facade :)";
                    boolean compress = true;
                    boolean encrypt = true;

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

            interface Data {

                void save(String data);
            }

            class CloudData implements Data {

                protected String url;

                public CloudData(String url) {
                    this.url = url;
                }

                @Override
                public void save(String data) {
                    System.out.println("Saving data " + data + " to cloud to " + url);
                }
            }

            abstract class DataDecorator implements Data {

                protected Data data;

                public DataDecorator(Data data) {
                    this.data = data;
                }

                public abstract void save(String data);
            }

            class CompressionDecorator extends DataDecorator {

                public CompressionDecorator(Data data) {
                    super(data);
                }

                @Override
                public void save(String data) {

                    String compressed = compress(data);
                    super.data.save(compressed);

                    System.out.println("Data compressed successfully!!!");
                }

                public String compress(String data) {
                    return data.substring(0, 9);
                }
            }

            class EncryptionDecorator extends DataDecorator {

                public EncryptionDecorator(Data data) {
                    super(data);
                }

                @Override
                public void save(String data) {

                    String encrypted = encrypt(data);
                    super.data.save(encrypted);

                    System.out.println("Data encrypted successfully!!!");
                }

                public String encrypt(String data) {
                    return "*$%#@!yuuioo)98876tyyu";
                }
            }

 */

public class Notes {
    public static void main(String[] args) {

        String url = "https://google.cloud.com";
        String data = "This is some data. Hello world. Facade :)";
        boolean compress = true;
        boolean encrypt = true;

        Data cloudData = new CloudData(url);

        if (compress)
            cloudData = new CompressionDecorator(cloudData);

        if (encrypt)
            cloudData = new EncryptionDecorator(cloudData);

        cloudData.save(data);
    }
}

interface Data {

    void save(String data);
}

class CloudData implements Data {

    protected String url;

    public CloudData(String url) {
        this.url = url;
    }

    @Override
    public void save(String data) {
        System.out.println("Saving data " + data + " to cloud to " + url);
    }
}

abstract class DataDecorator implements Data {

    protected Data data;

    public DataDecorator(Data data) {
        this.data = data;
    }

    public abstract void save(String data);
}

class CompressionDecorator extends DataDecorator {

    public CompressionDecorator(Data data) {
        super(data);
    }

    @Override
    public void save(String data) {

        String compressed = compress(data);
        super.data.save(compressed);

        System.out.println("Data compressed successfully!!!");
    }

    public String compress(String data) {
        return data.substring(0, 9);
    }
}

class EncryptionDecorator extends DataDecorator {

    public EncryptionDecorator(Data data) {
        super(data);
    }

    @Override
    public void save(String data) {

        String encrypted = encrypt(data);
        super.data.save(encrypted);

        System.out.println("Data encrypted successfully!!!");
    }

    public String encrypt(String data) {
        return "*$%#@!yuuioo)98876tyyu";
    }
}
