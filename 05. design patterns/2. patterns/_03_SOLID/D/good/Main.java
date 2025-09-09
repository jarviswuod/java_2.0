package _03_SOLID.D.good;

public class Main {
    public static void main(String[] args) {

        Car car = new Car(new Engine());
        car.startCar();
    }
}
