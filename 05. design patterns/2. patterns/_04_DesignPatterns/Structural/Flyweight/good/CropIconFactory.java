package _04_DesignPatterns.Structural.Flyweight.good;

import java.util.HashMap;
import java.util.Map;

public class CropIconFactory {

    // cache
    private Map<CropType, CropIcon> icons = new HashMap<>();

    public CropIcon getCropIcon(CropType cropType) {
        if (!icons.containsKey(cropType)) {

            CropIcon icon = new CropIcon(cropType, null);
            icons.put(cropType, icon);
        }

        return icons.get(cropType);
    }

}
