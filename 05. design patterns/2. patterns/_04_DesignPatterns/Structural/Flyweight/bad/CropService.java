package _04_DesignPatterns.Structural.Flyweight.bad;

import java.util.ArrayList;
import java.util.List;

public class CropService {

    public List<Crop> getCrops() {
        List<Crop> cropList = new ArrayList<>();

        // fetch from db
        Crop carrot1 = new Crop(1, 4, CropType.Carrot, null);
        Crop carrot2 = new Crop(1, 5, CropType.Carrot, null);
        Crop carrot3 = new Crop(1, 6, CropType.Carrot, null);
        Crop carrot4 = new Crop(1, 9, CropType.Carrot, null);

        cropList.add(carrot1);
        cropList.add(carrot2);
        cropList.add(carrot3);
        cropList.add(carrot4);

        return cropList;
    }
}
