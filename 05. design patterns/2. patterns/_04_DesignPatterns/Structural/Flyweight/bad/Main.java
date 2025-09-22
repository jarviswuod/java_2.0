package _04_DesignPatterns.Structural.Flyweight.bad;

public class Main {
    public static void main(String[] args) {

        CropService cropService = new CropService();

        for (Crop crop : cropService.getCrops()) {
            crop.render();
        }
    }
}
