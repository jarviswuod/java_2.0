package _04_DesignPatterns.Structural.Flyweight.good;

public class CropIcon {

    private CropType type;
    private byte[] icon;

    public CropIcon(CropType type, byte[] icon) {
        this.type = type;
        this.icon = icon;
    }

    public CropType getType() {
        return type;
    }

}
