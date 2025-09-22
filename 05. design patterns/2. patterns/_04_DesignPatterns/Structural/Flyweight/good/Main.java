package _04_DesignPatterns.Structural.Flyweight.good;

public class Main {
    public static void main(String[] args) {

        CropService cropService = new CropService(new CropIconFactory());

        for (Crop crop : cropService.getCrops()) {
            crop.render();
        }
    }
}
