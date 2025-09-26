package _04_DesignPatterns.Creational.Builder.director;

import _04_DesignPatterns.Creational.Builder.Components.*;

public interface Builder {

    void reset();

    Builder setCarType(CarType type);

    Builder setSeats(int seats);

    Builder setIsConvertible(boolean isConvertible);

    Builder setEngine(Engine engine);

    Builder setDashboard(Dashboard dashboard);

    Builder setWheels(Wheels wheels);

    Builder setGPSNavigator(GpsNavigator gpsNavigator);
}
