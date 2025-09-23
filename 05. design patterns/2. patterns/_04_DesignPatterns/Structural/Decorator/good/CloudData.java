package _04_DesignPatterns.Structural.Decorator.good;

public class CloudData implements Data {

    protected String url;

    public CloudData(String url) {
        this.url = url;
    }

    @Override
    public void save(String data) {
        System.out.println("Saving data " + data + " to cloud to " + url);
    }
}
