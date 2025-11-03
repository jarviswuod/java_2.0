public class Composition {
    public static void main(String[] args) {
        Car car = new Car(new Electric());

        car.setChassis(new Chassis_());
        car.setSeats(new Seats_());
        car.setWheels(new Wheels_());

        car.startCar();

        System.out.println();

        car.setEngine(new Petrol());
        car.startCar();
    }
}

class Car {
    private Engine engine;
    private Wheels wheels;
    private Chassis chassis;
    private Seats seats;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.ignite();
        wheels.roll();
        chassis.support();
        seats.adjust();
    }
}

interface Engine {

    public void ignite();
}

interface Wheels {

    public void roll();
}

interface Chassis {

    public void support();
}

interface Seats {

    public void adjust();
}

class Electric implements Engine {

    public void ignite() {
        System.out.println("Electric Engine started");
    }
}

class Petrol implements Engine {

    public void ignite() {
        System.out.println("petrol Engine started");
    }
}

class Wheels_ implements Wheels {

    @Override
    public void roll() {
        System.out.println("Rolling");
    }
}

class Chassis_ implements Chassis {

    @Override
    public void support() {
        System.out.println("Supporting");
    }
}

class Seats_ implements Seats {

    @Override
    public void adjust() {
        System.out.println("Warming up");
    }
}