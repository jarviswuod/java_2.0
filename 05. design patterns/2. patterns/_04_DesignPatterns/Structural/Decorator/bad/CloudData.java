package _04_DesignPatterns.Structural.Decorator.bad;

public class CloudData {

    protected String url;

    public CloudData(String url) {
        this.url = url;
    }

    public void save(String data) {
        System.out.println("Saving data " + data + " to cloud to " + url);
    }
}
