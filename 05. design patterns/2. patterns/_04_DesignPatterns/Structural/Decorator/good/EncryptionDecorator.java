package _04_DesignPatterns.Structural.Decorator.good;

public class EncryptionDecorator extends DataDecorator {

    public EncryptionDecorator(Data data) {
        super(data);
    }

    @Override
    public void save(String data_) {

        String encrypted = encrypt(data_);
        super.data.save(encrypted);

        System.out.println("Data encrypted successfully!!!");
    }

    public String encrypt(String data_) {
        return "*$%#@!yuuioo)98876tyyu";
    }
}
