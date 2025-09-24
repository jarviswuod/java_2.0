package _04_DesignPatterns.Structural.Flyweight.bad;

public class Crop {

    private int x; // 4 bytes
    private int y; // 4 bytes
    private CropType cropType; // 40 bytes * 1000 crops --> 40mb
    private byte[] icon; // 4 bytes

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
