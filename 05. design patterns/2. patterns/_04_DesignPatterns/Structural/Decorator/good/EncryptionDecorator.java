package _04_DesignPatterns.Structural.Decorator.good;

public class EncryptionDecorator extends DataDecorator {

    public EncryptionDecorator(Data data) {
        super(data);
    }

    @Override
    public void save(String data) {

        System.out.println("Encrypting data");
        String encrypted = Encrypt(data);
        super.data.save(encrypted);
    }

    public String Encrypt(String data) {
        return "*$%#@!yuuioo)98876tyyu";
    }
}
