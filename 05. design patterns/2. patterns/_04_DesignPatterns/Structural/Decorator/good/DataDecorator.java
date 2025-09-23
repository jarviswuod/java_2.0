package _04_DesignPatterns.Structural.Decorator.good;

public abstract class DataDecorator implements Data {

    protected Data data;

    public DataDecorator(Data data) {
        this.data = data;
    }

    // public abstract save(String data);
}
