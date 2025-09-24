package _04_DesignPatterns.Structural.Flyweight.good;

public class Crop {

    private int x;
    private int y;
    private CropIcon cropIcon;

    public Crop(int x, int y, CropIcon cropIcon) {
        this.x = x;
        this.y = y;
        this.cropIcon = cropIcon;
    }

    public void render() {
        System.out.println("Crop [x=" + x + ", y=" + y + ", cropType=" + cropIcon.getType() + "]");
    }
}
