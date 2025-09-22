package _04_DesignPatterns.Structural.Flyweight.bad;

public class Crop {

    private int x;
    private int y;
    private CropType cropType;
    private byte[] icon;

    public Crop(int x, int y, CropType cropType, byte[] icon) {
        this.x = x;
        this.y = y;
        this.cropType = cropType;
        this.icon = icon;
    }

    public void render() {
        System.out.println("Crop [x=" + x + ", y=" + y + ", cropType=" + cropType + "]");
    }
}
