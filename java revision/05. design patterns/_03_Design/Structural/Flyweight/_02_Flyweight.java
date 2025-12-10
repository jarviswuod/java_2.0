package _03_Design.Structural.Flyweight;

import java.util.Arrays;
import java.util.List;

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

        _02_CropService cropService = new _02_CropService();

        for (_02_Crop crop : cropService.getCropList()) {
            System.out.println(crop);
        }
    }
}

enum _02_CropType {

    Maize, Carrot, Wheat;
}

class _02_Crop {

    private int x;
    private int y;
    private _02_CropType cropType;
    private byte[] icon;

    public _02_Crop(int x, int y, _02_CropType cropType, byte[] icon) {
        this.x = x;
        this.y = y;
        this.cropType = cropType;
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "_02_Crop [x=" + x + ", y=" + y + ", cropType=" + cropType + ", icon=" + Arrays.toString(icon) + "]";
    }
}

class _02_CropService {

    public List<_02_Crop> getCropList() {

        List<_02_Crop> crops = List.of(
                new _02_Crop(3, 3, _02_CropType.Carrot, null),
                new _02_Crop(1, 9, _02_CropType.Carrot, null),
                new _02_Crop(2, 7, _02_CropType.Carrot, null),
                new _02_Crop(4, 0, _02_CropType.Carrot, null),
                new _02_Crop(5, 1, _02_CropType.Carrot, null));

        return crops;
    }
}