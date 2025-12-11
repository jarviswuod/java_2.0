package _03_Design.Structural.Flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    NOTES:
    - Is a structural pattern that shared an object state between multiple object saving memory in return
    - Key Players:
        - Flyweight Factory
        - Flyweight classes
        - Class Object

    - Examples:
        - Farmer and Icons

*/

public class _02_Flyweight {
    public static void main(String[] args) {

        _02_CropService cropService = new _02_CropService(new _02_CropIconFactory());

        for (_02_Crop crop : cropService.getCropList()) {
            System.out.println(crop);
        }
    }
}

enum _02_CropType {

    Maize, Carrot, Wheat;
}

class _02_CropIcon {

    private _02_CropType cropType;
    private byte[] icon;

    public _02_CropIcon(_02_CropType cropType, byte[] icon) {
        this.cropType = cropType;
        this.icon = icon;
    }
}

class _02_CropIconFactory {

    private Map<_02_CropType, _02_CropIcon> stored = new HashMap<>();

    public _02_CropIcon getCropIcon(_02_CropType cropType) {
        if (!stored.containsKey(cropType)) {
            stored.put(cropType, new _02_CropIcon(cropType, null));
        }
        return stored.get(cropType);
    }
}

class _02_Crop {

    private int x;
    private int y;
    private _02_CropIcon cropIcon;

    public _02_Crop(int x, int y, _02_CropIcon cropIcon) {
        this.x = x;
        this.y = y;
        this.cropIcon = cropIcon;
    }

    @Override
    public String toString() {
        return "_02_Crop [x=" + x + ", y=" + y + ", cropIcon=" + cropIcon + "]";
    }
}

class _02_CropService {

    private _02_CropIconFactory factory;

    public _02_CropService(_02_CropIconFactory factory) {
        this.factory = factory;
    }

    public List<_02_Crop> getCropList() {

        List<_02_Crop> crops = List.of(
                new _02_Crop(3, 3, factory.getCropIcon(_02_CropType.Carrot)),
                new _02_Crop(1, 9, factory.getCropIcon(_02_CropType.Carrot)),
                new _02_Crop(2, 7, factory.getCropIcon(_02_CropType.Carrot)),
                new _02_Crop(4, 0, factory.getCropIcon(_02_CropType.Carrot)),
                new _02_Crop(5, 1, factory.getCropIcon(_02_CropType.Carrot)));

        return crops;
    }
}
