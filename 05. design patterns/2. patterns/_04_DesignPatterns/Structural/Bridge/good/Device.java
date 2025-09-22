package _04_DesignPatterns.Structural.Bridge.good;

public interface Device {

    public void turnOn();

    public void turnOff();

    public void volumeUp();

    public void volumeDown();

    public void setChannel(int channel);
}
