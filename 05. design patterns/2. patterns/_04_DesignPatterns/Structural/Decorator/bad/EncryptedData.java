package _04_DesignPatterns.Structural.Decorator.bad;

public class EncryptedData extends CloudData {

    public EncryptedData(String url) {
        super(url);
    }

    @Override
    public void save(String data) {
        String encrypted = Encrypt(data);
        super.save(encrypted);
    }

    public String Encrypt(String data) {
        return "*$%#@!yuuioo)98876tyyu";
    }
}
