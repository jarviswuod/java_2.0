public class _33_AbstractKeywords {
    public static void main(String[] args) {
        // Car car = new Car(); // Cannot instantiate the type Car

        Car car = new WagonR();
        car.drive();
        car.playMusic();
        car.fly();
    }
}

abstract class Car { // Abstract class
    public abstract void drive();

    public abstract void fly();

    public void playMusic() {
        System.out.println("Playing Music");
    }
}

class WagonR extends Car { // Concrete class
    public void drive() {
        System.out.println("WagonR driving");
    }

    public void fly() {
        System.out.println("updatedWagonR flying...");
    }
}

class updatedWagonR extends WagonR { // Concrete class
    public void fly() {
        System.out.println("updatedWagonR flying...");
    }
}