package _03_Design.Structural.Flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    NOTES:
    - Is a structural design pattern that enables sharing of object state between multiple objects aiming to save on memory space
    - Key players:
        - Flyweight Factory
        - Flyweight Class
        - Object class

    - Example:
        - Farm and Crop

*/

public class _01_Flyweight {
    public static void main(String[] args) {

        CropService cropService = new CropService(new CropFactory());

        for (Crop crop : cropService.getCropsList()) {
            // System.out.println("Crop with " + crop.getX() + " " + crop.getY() + " " +
            // crop.getCropIcon());
            crop.render();
        }
    }
}

enum CropType {

    Carrot, Maize, Cassava;
}

class CropIcon {

    private CropType croptype;
    private byte[] icon;

    public CropIcon(CropType croptype, byte[] icon) {
        this.croptype = croptype;
        this.icon = icon;
    }

    public CropType getCroptype() {
        return croptype;
    }
}

class Crop {

    private int x;
    private int y;

    private CropIcon cropIcon;

    public Crop(int x, int y, CropIcon cropIcon) {
        this.x = x;
        this.y = y;
        this.cropIcon = cropIcon;
    }

    public void render() {
        System.out.println("Crop with " + x + " " + y + " " + cropIcon);
    }
}

class CropFactory {
    private Map<CropType, CropIcon> icons = new HashMap<>();

    public CropIcon getCroptype(CropType cropType) {

        if (!icons.containsKey(cropType)) {
            CropIcon cropIcon = new CropIcon(cropType, null);
            icons.put(cropType, cropIcon);
        }

        return icons.get(cropType);
    }
}

class CropService {

    private CropFactory cropFactory;

    public CropService(CropFactory cropFactory) {
        this.cropFactory = cropFactory;
    }

    public List<Crop> getCropsList() {

        Crop crop1 = new Crop(1, 3, cropFactory.getCroptype(CropType.Carrot));
        Crop crop2 = new Crop(4, 1, cropFactory.getCroptype(CropType.Carrot));
        Crop crop3 = new Crop(3, 2, cropFactory.getCroptype(CropType.Carrot));
        Crop crop4 = new Crop(5, 9, cropFactory.getCroptype(CropType.Carrot));
        Crop crop5 = new Crop(6, 4, cropFactory.getCroptype(CropType.Carrot));

        List<Crop> crops = List.of(crop1, crop2, crop3, crop4, crop5);

        return crops;
    }
}
