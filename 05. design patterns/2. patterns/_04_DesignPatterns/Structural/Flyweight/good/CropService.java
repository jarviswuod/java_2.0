package _04_DesignPatterns.Structural.Flyweight.good;

import java.util.ArrayList;
import java.util.List;

public class CropService {

    private CropIconFactory cropIconFactory;

    public CropService(CropIconFactory cropIconFactory) {
        this.cropIconFactory = cropIconFactory;
    }

    public List<Crop> getCrops() {
        List<Crop> cropList = new ArrayList<>();

        // fetch from db
        Crop carrot1 = new Crop(1, 4, cropIconFactory.getCropIcon(CropType.Carrot));
        Crop carrot2 = new Crop(1, 5, cropIconFactory.getCropIcon(CropType.Carrot));
        Crop carrot3 = new Crop(2, 6, cropIconFactory.getCropIcon(CropType.Carrot));
        Crop carrot4 = new Crop(2, 8, cropIconFactory.getCropIcon(CropType.Carrot));

        cropList.add(carrot1);
        cropList.add(carrot2);
        cropList.add(carrot3);
        cropList.add(carrot4);

        return cropList;
    }
}
