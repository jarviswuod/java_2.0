package _04_DesignPatterns.Creational.Builder.director;

public class Main {
    public static void main(String[] args) {

        CarBuilder carBuilder = new CarBuilder();
        Director director = new Director();

        director.constructSportsCar(carBuilder);
        Car sportsCar = carBuilder.getCar();
        sportsCar.setFuel(100);

        director.constructSUV(carBuilder);
        Car suvCar = carBuilder.getCar();
        suvCar.setFuel(40);

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual sportsCarManual = manualBuilder.getManual();
        System.out.println(sportsCarManual);

        director.constructSUV(manualBuilder);
        Manual suvCarManual = manualBuilder.getManual();
        System.out.println(suvCarManual);

    }
}
